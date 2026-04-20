package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class viewAccounts extends JPanel {

    public viewAccounts() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 650));

        // ── Main Content Container ──────────────────────────────────────
        JPanel accountContainer = new JPanel();
        accountContainer.setLayout(null);
        accountContainer.setBackground(Color.WHITE);

        // --- Title ---
        JLabel title = new JLabel("Account Overview");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(50, 30, 400, 50);
        accountContainer.add(title);

        User currentUser = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);

        // --- Profile Section (The White Box) ---
        JPanel profilePanel = new JPanel(null);
        profilePanel.setBounds(50, 100, 900, 280);
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        accountContainer.add(profilePanel);

        setupProfileLabels(profilePanel, currentUser);

        int sectionY = 410; // Start position for Accounts/Loans headers

        // --- Bank Accounts Column ---
        JLabel accHeader = new JLabel("Bank Accounts");
        accHeader.setFont(new Font("Arial", Font.BOLD, 22));
        accHeader.setBounds(50, sectionY, 300, 35);
        accountContainer.add(accHeader);

        int leftY = sectionY + 50;

        // Render Savings
        if (currentUser.getSavingsAccounts() != null) {
            for (SavingsAccount sa : currentUser.getSavingsAccounts()) {
                renderAccountBox(accountContainer, "Savings", sa.getAccountNumber(), sa.getBalance(), 50, leftY);
                leftY += 100;
            }
        }

        // Render Current
        if (currentUser.getCurrentAccounts() != null) {
            for (CurrentAccount ca : currentUser.getCurrentAccounts()) {
                renderAccountBox(accountContainer, "Current", ca.getAccountNumber(), ca.getBalance(), 50, leftY);
                leftY += 100;
            }
        }

        // --- Active Loans Column ---
        JLabel loanHeader = new JLabel("Active Loans");
        loanHeader.setFont(new Font("Arial", Font.BOLD, 22));
        loanHeader.setBounds(520, sectionY, 300, 35);
        accountContainer.add(loanHeader);

        int rightY = sectionY + 50;
        List<Loan> loans = currentUser.getLoans();

        if (loans == null || loans.isEmpty()) {
            JLabel noLoan = new JLabel("No active loans found.");
            noLoan.setFont(new Font("Arial", Font.PLAIN, 14));
            noLoan.setForeground(Color.GRAY);
            noLoan.setBounds(520, rightY, 300, 30);
            accountContainer.add(noLoan);
            rightY += 40;
        } else {
            for (Loan l : loans) {
                // Pass all loan details to the box renderer
                renderLoanBox(accountContainer,
                        l.getLoanID(),
                        l.getPaymentAmount(),
                        l.getMonthlyInstallment(),
                        l.getInterestRate(),
                        l.getLoanPeriod(),
                        520,
                        rightY);
                rightY += 120; // Increased spacing for more detailed boxes
            }
        }

        // Adjust scrollable height based on content
        int totalHeight = Math.max(leftY, rightY) + 50;
        accountContainer.setPreferredSize(new Dimension(1000, totalHeight));

        // --- Scroll Pane Setup ---
        JScrollPane scrollPane = new JScrollPane(accountContainer);
        scrollPane.setBounds(0, 0, 1000, 650);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.add(scrollPane);
    }

    // Helper to setup the profile info in two columns
    private void setupProfileLabels(JPanel p, User u) {
        String[][] labels = {
                {"Name:", u.getName()},       {"Address:", u.getAddress()},
                {"User ID:", u.getUserID()},   {"Username:", u.getUsername()},
                {"IC No:", u.getIC_No()},     {"Occupation:", u.getOccupation()},
                {"Gender:", u.getGender()},   {"Gross Income:", "RM " + u.getGrossIncome()},
                {"Tel No:", u.getTelNo()},     {"Net Income:", "RM " + u.getNetIncome()}
        };

        int startX = 30, startY = 30, labelWidth = 120, valueWidth = 250, spacingY = 45;

        for (int i = 0; i < labels.length; i++) {
            int col = i % 2;
            int row = i / 2;
            int xOffset = col * 450;

            JLabel k = new JLabel(labels[i][0]);
            k.setFont(new Font("Arial", Font.BOLD, 13));
            k.setBounds(startX + xOffset, startY + (row * spacingY), labelWidth, 25);

            JLabel v = new JLabel(labels[i][1] != null ? labels[i][1] : "N/A");
            v.setFont(new Font("Arial", Font.PLAIN, 13));
            v.setBounds(startX + xOffset + labelWidth, startY + (row * spacingY), valueWidth, 25);

            p.add(k); p.add(v);
        }
    }

    private void renderAccountBox(JPanel p, String type, String num, double bal, int x, int y) {
        JPanel b = new JPanel(null);
        b.setBounds(x, y, 430, 85); // Increased height to accommodate the preview line
        b.setBackground(Color.WHITE);
        b.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(70, 130, 180)));

        JLabel n = new JLabel(type + " - " + num);
        n.setFont(new Font("Arial", Font.BOLD, 14));
        n.setBounds(15, 10, 350, 20);

        JLabel bl = new JLabel("Current Balance: RM " + String.format("%.2f", bal));
        bl.setFont(new Font("Monospaced", Font.PLAIN, 13));
        bl.setBounds(15, 30, 350, 20);

        if (type.equalsIgnoreCase("Savings")) {
            double rate = 0.0;
            // Apply tiered rates from SavingsAccount logic
            if (bal < 1000) rate = 0.01;
            else if (bal < 20000) rate = 0.02;
            else rate = 0.04;

            double estimatedTotal = bal + (bal * rate);

            JLabel estLabel = new JLabel("Est. Balance (1 Year): RM " + String.format("%.2f", estimatedTotal));
            estLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            estLabel.setForeground(new Color(0, 128, 0)); // Green color for interest preview
            estLabel.setBounds(15, 55, 350, 20);
            b.add(estLabel);
        }

        b.add(n);
        b.add(bl);
        p.add(b);
    }

    private void renderLoanBox(JPanel p, String id, double totalAmount, double monthly, double rate, double period, int x, int y) {
        JPanel b = new JPanel(null);
        b.setBounds(x, y, 430, 105);
        b.setBackground(Color.WHITE);
        b.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(192, 57, 43)));

        JLabel idLabel = new JLabel("Loan ID: " + id);
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        idLabel.setBounds(15, 10, 350, 20);

        // FIX: Label changed to Total Loan Amount and formatted to 2 decimals
        JLabel outLabel = new JLabel("Total Loan Amount: RM " + String.format("%.2f", totalAmount));
        outLabel.setBounds(15, 30, 350, 20);

        // FIX: Monthly Installment formatted to 2 decimals
        JLabel monthlyLabel = new JLabel("Monthly Installment: RM " + String.format("%.2f", monthly));
        monthlyLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        monthlyLabel.setForeground(Color.GRAY);
        monthlyLabel.setBounds(15, 50, 350, 20);

        // FIX: Interest Rate formatted to 1 decimal place to remove the long trailing digits
        JLabel rateLabel = new JLabel("Interest Rate: " + String.format("%.1f", (rate * 100)) + "%");
        rateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        rateLabel.setBounds(15, 70, 200, 20);

        JLabel periodLabel = new JLabel("Period: " + (int)period + " Years");
        periodLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        periodLabel.setBounds(220, 70, 150, 20);

        b.add(idLabel);
        b.add(outLabel);
        b.add(monthlyLabel);
        b.add(rateLabel);
        b.add(periodLabel);
        p.add(b);
    }
}