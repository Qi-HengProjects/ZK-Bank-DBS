package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class viewStatements extends JPanel {

    GUI ui = new GUI();

    public viewStatements() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 650));

        JPanel statementContainer = new JPanel();
        statementContainer.setLayout(null);
        statementContainer.setPreferredSize(new Dimension(1000, 2000));

        JLabel transactionTitle = new JLabel("Transaction History");
        transactionTitle.setFont(new Font("Arial", Font.BOLD, 30));
        transactionTitle.setBounds(200, 50, 400, 50);
        statementContainer.add(transactionTitle);

        int currentY = 120;
        int elementHeight = 60;
        int spacing = 10;

        // Pass the current logged-in user's ID here
        String currentUserID = Main.currentSession;
        List<String[]> transactionList = Main.dataManager.generateStatement(currentUserID);

        if (transactionList != null && !transactionList.isEmpty()) {
            for (String[] transaction : transactionList) {
                // transaction[0] = amount, [1] = ID, [2] = status, [3] = date, [4] = details
                String label = "ID: " + transaction[1] + "  |  " + transaction[3] + "  |  RM " + transaction[0] + "  |  " + transaction[2];
                JButton txnButton = new JButton(label);
                txnButton.setBounds(200, currentY, 600, elementHeight);
                txnButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

                txnButton.addActionListener(q -> {
                    displayStatement(statementContainer, transaction);
                });

                statementContainer.add(txnButton);
                currentY += (elementHeight + spacing);
            }

            statementContainer.setPreferredSize(new Dimension(1000, Math.max(700, currentY + 100)));

        } else {
            JLabel nothingHereLabel = new JLabel("No transactions found!");
            nothingHereLabel.setFont(new Font("Arial", Font.BOLD, 20));
            ui.setPosition(nothingHereLabel, 400, 200, 300, 50);
            statementContainer.add(nothingHereLabel);
        }

        JScrollPane scrollPane = new JScrollPane(statementContainer);
        scrollPane.setBounds(0, 0, 1000, 650);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
    }


    public static void displayStatement(JPanel innerStatementContainer, String[] transactionData) {
        GUI ui = new GUI();

        innerStatementContainer.removeAll();

        // Matches the order returned by generateStatement()
        // [amount, transactionID, status, date, details]
        String[] transactionKeys = {
                "Amount (RM):",
                "Transaction ID:",
                "Status:",
                "Date:",
                "Details:"
        };

        int startX = 50;
        int startY = 100;
        int labelWidth = 150;
        int valueWidth = 300;
        int height = 30;
        int verticalSpacing = 40;

        Component lastComponent = null;

        for (int i = 0; i < transactionKeys.length; i++) {
            JLabel keyLabel = new JLabel(transactionKeys[i]);
            keyLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel valueLabel = new JLabel(transactionData[i]);
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));

            if (i == 0) {
                ui.setPosition(keyLabel, startX, startY, labelWidth, height);
            } else {
                ui.setPositionRelative(lastComponent, keyLabel, 0, verticalSpacing, labelWidth, height);
            }

            ui.setPositionRelative(keyLabel, valueLabel, labelWidth + 10, 0, valueWidth, height);

            innerStatementContainer.add(keyLabel);
            innerStatementContainer.add(valueLabel);
            lastComponent = keyLabel;
        }

        // Back button — goes back to the transaction list
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(100, 50, 100, 20);
        backBtn.addActionListener(e -> {
            Main.showPage("viewStatements"); // adjust page name to match yours
        });
        innerStatementContainer.add(backBtn);

        innerStatementContainer.revalidate();
        innerStatementContainer.repaint();
    }
}