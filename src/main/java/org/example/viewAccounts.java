package org.example;
import javax.swing.*;
import java.awt.*;

public class viewAccounts extends JPanel {

    public viewAccounts() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 650));

        // ── Inner content panel ──────────────────────────────────────────
        JPanel accountContainer = new JPanel();
        accountContainer.setLayout(null);

        JLabel title = new JLabel("Account Details");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(200, 50, 400, 50);
        accountContainer.add(title);

        User currentUser = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);

        String[] keys = {
                "Name:", "User ID:", "IC No:", "Birthday:",
                "Gender:", "Nationality:", "Race:", "Religion:",
                "Tel No:", "Address:", "Username:", "Company:",
                "Occupation:", "Income Source:", "Gross Income:", "Net Income:"
        };

        String[] values = {
                currentUser.getName(),        currentUser.getUserID(),
                currentUser.getIC_No(),       currentUser.getBirthday(),
                currentUser.getGender(),      currentUser.getNationality(),
                currentUser.getRace(),        currentUser.getReligion(),
                currentUser.getTelNo(),       currentUser.getAddress(),
                currentUser.getUsername(),    currentUser.getCompany(),
                currentUser.getOccupation(),  currentUser.getIncomeSource(),
                currentUser.getGrossIncome(), currentUser.getNetIncome()
        };

        int startX = 200;
        int startY = 120;
        int labelWidth = 150;
        int valueWidth = 300;
        int height = 30;
        int spacing = 40;

        for (int i = 0; i < keys.length; i++) {
            JLabel keyLabel = new JLabel(keys[i]);
            keyLabel.setFont(new Font("Arial", Font.BOLD, 14));
            keyLabel.setBounds(startX, startY + (i * spacing), labelWidth, height);

            JLabel valueLabel = new JLabel(values[i] != null ? values[i] : "N/A");
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            valueLabel.setBounds(startX + labelWidth + 10, startY + (i * spacing), valueWidth, height);

            accountContainer.add(keyLabel);
            accountContainer.add(valueLabel);
        }

        int containerHeight = Math.max(700, startY + (keys.length * spacing) + 100);
        accountContainer.setPreferredSize(new Dimension(1000, containerHeight));

        // ── Scroll pane with smooth scrolling ────────────────────────────
        JScrollPane scrollPane = new JScrollPane(accountContainer);
        scrollPane.setBounds(0, 0, 1000, 650);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        // Smooth scrolling — lower unit increment = smoother feel
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
        scrollPane.getVerticalScrollBar().setBlockIncrement(60);

        this.add(scrollPane);
    }
}