package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class statementUI extends JPanel {

    public statementUI() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 650));

        // ── Main Container ──────────────────────────────────────────────
        JPanel container = new JPanel();
        container.setLayout(null);
        container.setBackground(new Color(245, 245, 245)); // Light grey background

        // ── Header ──────────────────────────────────────────────────────
        JLabel title = new JLabel("Transaction History");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(50, 30, 400, 50);
        container.add(title);

        // Fetch current user data
        User currentUser = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);

        int currentY = 100;

        // ── Check if user has transactions ──────────────────────────────
        if (currentUser != null && currentUser.getTransactions() != null && !currentUser.getTransactions().isEmpty()) {

            List<Transaction> transactions = currentUser.getTransactions();

            // Loop backwards so the NEWEST transactions appear at the top
            for (int i = transactions.size() - 1; i >= 0; i--) {
                Transaction t = transactions.get(i);

                // Call the helper method to draw the transaction box on the GUI
                renderTransactionBox(container,
                        t.getTransactionID(),
                        t.getTransactionDate(),
                        t.getTransactionDetails(),
                        t.getTransactionAmount(),
                        50,
                        currentY);

                currentY += 90; // Spacing between each transaction box
            }

        } else {
            // Message to print if the account is brand new and has no history
            JLabel noHistory = new JLabel("No transaction history available.");
            noHistory.setFont(new Font("Arial", Font.ITALIC, 16));
            noHistory.setForeground(Color.GRAY);
            noHistory.setBounds(50, currentY, 400, 30);
            container.add(noHistory);
        }

        // ── Finalize Scroll Settings ────────────────────────────────────
        container.setPreferredSize(new Dimension(1000, currentY + 100));

        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setBounds(0, 0, 1000, 650);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling
        this.add(scrollPane);
    }

    // ── UI Helper Method: Draws the Transaction Box ───────────────────
    private void renderTransactionBox(JPanel panel, String id, String date, String details, double amount, int x, int y) {
        JPanel box = new JPanel(null);
        box.setBounds(x, y, 900, 75);
        box.setBackground(Color.WHITE);

        // Logic: Green border for Money IN (Positive), Red border for Money OUT (Negative)
        Color accentColor = (amount >= 0) ? new Color(46, 204, 113) : new Color(231, 76, 60);
        box.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, accentColor));

        // Date Label
        JLabel dateLbl = new JLabel(date);
        dateLbl.setFont(new Font("Arial", Font.BOLD, 14));
        dateLbl.setBounds(15, 10, 150, 20);

        // Transaction ID (Reference)
        JLabel idLbl = new JLabel("Ref: " + id);
        idLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        idLbl.setForeground(new Color(150, 150, 150));
        idLbl.setBounds(150, 10, 200, 20);

        // Transaction Details (This is where the Transfer Fee text will automatically appear!)
        JLabel detailsLbl = new JLabel(details);
        detailsLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsLbl.setBounds(15, 40, 600, 20); // Wide width to fit the fee description

        // Format Amount String (Adds + or - and RM)
        String formattedAmount = (amount >= 0 ? "+ RM " : "- RM ") + String.format("%.2f", Math.abs(amount));
        JLabel amtLbl = new JLabel(formattedAmount);
        amtLbl.setFont(new Font("Arial", Font.BOLD, 18));
        amtLbl.setForeground(accentColor);
        amtLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        amtLbl.setBounds(680, 25, 200, 25); // Pushed to the far right

        // Add elements to the box, and the box to the main panel
        box.add(dateLbl);
        box.add(idLbl);
        box.add(detailsLbl);
        box.add(amtLbl);
        panel.add(box);
    }
}