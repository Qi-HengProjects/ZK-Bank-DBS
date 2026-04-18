package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class statementUI extends JPanel{
    public static void statementUI(String userID) {
        JPanel statement = new JPanel();
        statement.removeAll();
        statement.setLayout(null);

        GUI ui = new GUI();
        List<String[]> transactions = Main.dataManager.generateStatement(userID);

        String[] headers = {"Amount", "ID", "Status", "Date", "Details"};
        int startX = 50, startY = 80, colWidth = 120, height = 25, verticalSpacing = 30;

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(startX, 20, 80, 30);
        backBtn.addActionListener(e -> Main.showPage("dashboard"));
        statement.add(backBtn);

        for (int i = 0; i < headers.length; i++) {
            JLabel headerLabel = new JLabel(headers[i]);
            headerLabel.setFont(new Font("Arial", Font.BOLD, 13));
            headerLabel.setBounds(startX + (i * colWidth), startY, colWidth, height);
            statement.add(headerLabel);
        }

        int currentRowY = startY + verticalSpacing;
        for (String[] rowData : transactions) {
            for (int j = 0; j < rowData.length; j++) {
                JLabel dataLabel = new JLabel(rowData[j]);
                dataLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                dataLabel.setBounds(startX + (j * colWidth), currentRowY, colWidth, height);
                statement.add(dataLabel);
            }
            currentRowY += verticalSpacing;
        }

        if (transactions.isEmpty()) {
            JLabel emptyMsg = new JLabel("No transactions found.");
            emptyMsg.setBounds(startX, currentRowY, 300, height);
            statement.add(emptyMsg);
        }



    }
}
