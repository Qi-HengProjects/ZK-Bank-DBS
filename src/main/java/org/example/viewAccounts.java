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
                leftY += 75;
            }
        }

        // Render Current
        if (currentUser.getCurrentAccounts() != null) {
            for (CurrentAccount ca : currentUser.getCurrentAccounts()) {
                renderAccountBox(accountContainer, "Current", ca.getAccountNumber(), ca.getBalance(), 50, leftY);
                leftY += 75;
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
                renderLoanBox(accountContainer, l.getLoanID(), l.getPaymentAmount(), 520, rightY);
                rightY += 75;
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

    // Standard box for Accounts (matches your screenshot style)
    private void renderAccountBox(JPanel p, String type, String num, double bal, int x, int y) {
        JPanel b = new JPanel(null);
        b.setBounds(x, y, 430, 60);
        b.setBackground(Color.WHITE);
        b.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(70, 130, 180)));

        JLabel n = new JLabel(type + " - " + num);
        n.setFont(new Font("Arial", Font.BOLD, 14));
        n.setBounds(15, 10, 350, 20);

        JLabel bl = new JLabel("Balance: RM " + String.format("%.2f", bal));
        bl.setFont(new Font("Monospaced", Font.PLAIN, 13));
        bl.setBounds(15, 30, 350, 20);

        b.add(n); b.add(bl);
        p.add(b);
    }

    // Standard box for Loans
    private void renderLoanBox(JPanel p, String id, double total, int x, int y) {
        JPanel b = new JPanel(null);
        b.setBounds(x, y, 430, 60);
        b.setBackground(Color.WHITE);
        b.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(192, 57, 43)));

        JLabel i = new JLabel("Loan ID: " + id);
        i.setFont(new Font("Arial", Font.BOLD, 14));
        i.setBounds(15, 10, 350, 20);

        JLabel t = new JLabel("Outstanding: RM " + String.format("%.2f", total));
        t.setBounds(15, 30, 350, 20);

        b.add(i); b.add(t);
        p.add(b);
    }
}