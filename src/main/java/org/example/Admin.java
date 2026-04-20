package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Admin extends JPanel {


    GUI ui = new GUI();
    public static class newAccountRequest extends JPanel {

        GUI ui = new GUI();
        public newAccountRequest() {
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000, 650));
            // temporary location for method

            // Container 1
            JPanel adminContainer1 = new JPanel();
            adminContainer1.setLayout(null);
            adminContainer1.setPreferredSize(new Dimension(1000, 2000)); // tall enough to scroll

            // Account Request Title Label
            JLabel accountRequestTitle = new JLabel("Account Request");
            accountRequestTitle.setFont(new Font("Arial", Font.BOLD, 30));
            accountRequestTitle.setBounds(200, 50, 300, 50);
            adminContainer1.add(accountRequestTitle);

            int currentY = 120;
            int elementHeight = 60;
            int spacing = 10;


            List<String[]> accountApplicationList = Main.dataManager.makeAccountApplicationList();
            if (accountApplicationList != null && !accountApplicationList.isEmpty()) {
                for (String[] applications : accountApplicationList) {
                    if (applications != null) {
                        // Frontend logic for the for each loop in the request array
                        // Display as long buttons without borders
                        // array for each into the ui element
                        // use setPositionRelative for automated position (in the for each loop)

                        String userName = applications[0];
                        JButton appButton = new JButton("User: " + userName + " (View Application)");
                        appButton.setBounds(200, currentY, 600, elementHeight);
                        appButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));


                        appButton.addActionListener(q -> {
                            // Pass the 'apps' array to the method above
                            displayAccApplicationDetails(adminContainer1, applications);

                            // Add Approve/Reject buttons at the bottom relative to the last item
                            // or show them if they were hidden
                        });
                        adminContainer1.add(appButton);

                        adminContainer1.add(appButton);
                        currentY += (elementHeight + spacing);
                    }
                }
            } else {

                JLabel nothingHereLabel = new JLabel("No requests!");
                nothingHereLabel.setFont(new Font("Arial", Font.BOLD,20));
                ui.setPosition(nothingHereLabel, 450, 315, 300, 20);
                adminContainer1.add(nothingHereLabel);
            }

            // Wrap contentPanel in scrollpane
            JScrollPane scrollPane = new JScrollPane(adminContainer1);
            scrollPane.setBounds(0, 0, 1000, 650);
            this.add(scrollPane); // scrollPane goes on the page
        }
    }


    public static class newLoanRequest extends JPanel {
        GUI ui = new GUI();

        public newLoanRequest() {
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000, 650));

            // The scrollable content container
            JPanel adminContainer2 = new JPanel();
            adminContainer2.setLayout(null);
            // Set height dynamically or keep it large enough for the list
            adminContainer2.setPreferredSize(new Dimension(1000, 2000));

            JLabel loanRequestTitle = new JLabel("Loan Request");
            loanRequestTitle.setFont(new Font("Arial", Font.BOLD, 30));
            loanRequestTitle.setBounds(200, 50, 300, 50);
            adminContainer2.add(loanRequestTitle); // Added to container

            int currentY = 120;
            int elementHeight = 60;
            int spacing = 10;

            List<String[]> loanApplicationList = Main.dataManager.makeLoanApplicationList();

            if (loanApplicationList != null && !loanApplicationList.isEmpty()) {
                for (String[] loanApplications : loanApplicationList) {
                    String userName = loanApplications[0];
                    JButton appButton = new JButton("User: " + userName + " (View Application)");
                    appButton.setBounds(200, currentY, 600, elementHeight);
                    appButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

                    appButton.addActionListener(q -> {
                        // Logic to clear and show details
                        displayLoanApplicationDetails(adminContainer2, loanApplications);
                    });

                    adminContainer2.add(appButton); // CRITICAL: Add to container
                    currentY += (elementHeight + spacing);
                }

                // Adjust container height based on number of items
                adminContainer2.setPreferredSize(new Dimension(1000, Math.max(700, currentY + 100)));

            } else {
                JLabel nothingHereLabel = new JLabel("No requests!");
                nothingHereLabel.setFont(new Font("Arial", Font.BOLD, 20));
                // Ensure UI helper adds it to adminContainer2
                ui.setPosition(nothingHereLabel, 400, 200, 300, 50);
                adminContainer2.add(nothingHereLabel);
            }

            // Wrap the container in the scroll pane
            JScrollPane scrollPane = new JScrollPane(adminContainer2);
            scrollPane.setBounds(0, 0, 1000, 650);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            this.add(scrollPane);
        }
    }

    public static void displayAccApplicationDetails(JPanel displayAccContainer, String[] applicationData) {
        GUI ui = new GUI();

        // 1. Clear the container
        displayAccContainer.removeAll();

        String[] accKeys = {
                "User ID:", "Company:", "Occupation:", "Income Source:",
                "Gross Income:", "Net Income:", "Account Type:",
                "App Type:", "Status:", "Initial Deposit:"
        };

        int startX = 50;
        int startY = 100;
        int labelWidth = 150;
        int valueWidth = 300;
        int height = 30;
        int verticalSpacing = 40;

        Component lastComponent = null;

        // LOOP ONLY FOR LABELS
        for (int i = 0; i < accKeys.length; i++) {
            JLabel keyLabel = new JLabel(accKeys[i]);
            keyLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel valueLabel = new JLabel(applicationData[i]);
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));

            if (i == 0) {
                ui.setPosition(keyLabel, startX, startY, labelWidth, height);
            } else {
                ui.setPositionRelative(lastComponent, keyLabel, 0, verticalSpacing, labelWidth, height);
            }

            ui.setPositionRelative(keyLabel, valueLabel, labelWidth + 10, 0, valueWidth, height);

            displayAccContainer.add(keyLabel);
            displayAccContainer.add(valueLabel);
            lastComponent = keyLabel; // Keep track of the last label
        }

        // 2. CREATE BUTTONS OUTSIDE THE LOOP (Prevents duplication)
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(100, 50, 100,20);
        backBtn.addActionListener(e -> {
            Main.showPage("accountRequest");
        });
        displayAccContainer.add(backBtn);


        JButton accountApprove = new JButton("Approve");
        JButton accountReject = new JButton("Reject");

        // Position buttons relative to the LAST label added in the loop
        // Move them down by 60 pixels from the last row

        ui.setPositionRelative(lastComponent, accountApprove, 0, 60, 120, 40);
        ui.setPositionRelative(accountApprove, accountReject, 140, 0, 120, 40);

        accountApprove.addActionListener(e -> {
            String targetID = applicationData[0];
            String accType = applicationData[7];
            double initialBalance = Double.parseDouble(applicationData[9]);

            Main.dataManager.updateData(targetID, User::getApplicationStatus, uObj -> uObj.setApplicationStatus("APPROVED"));
            Main.dataManager.addNewAccount(targetID, accType, initialBalance);
            JOptionPane.showMessageDialog(displayAccContainer, "Account Created for " + targetID);
            System.out.println("Approved: " + applicationData[0]);

            Main.showPage("accountRequest");
        });

        accountReject.addActionListener(e -> {
            String targetID = applicationData[0];

            Main.dataManager.updateData(targetID, User::getApplicationStatus, uObj -> uObj.setApplicationStatus("REJECTED"));
            JOptionPane.showMessageDialog(displayAccContainer, "Account Rejected for " + targetID);
            System.out.println("Rejected: " + applicationData[0]);

            Main.showPage("accountRequest");
        });

        displayAccContainer.add(accountApprove);
        displayAccContainer.add(accountReject);

        // 3. Refresh the UI
        displayAccContainer.revalidate();
        displayAccContainer.repaint();
    }



    public static void displayLoanApplicationDetails(JPanel displayLoanContainer, String[] applicationData) {
        GUI ui = new GUI();

        // 1. Clear the container
        displayLoanContainer.removeAll();

        String[] loanKeys = {
                "User ID:", "Company:", "Occupation:", "Income Source:",
                "Gross Income:", "Net Income:", "Loan Amount:",
                "Loan Period:"
        };

        int startX = 50;
        int startY = 100;
        int labelWidth = 150;
        int valueWidth = 300;
        int height = 30;
        int verticalSpacing = 40;

        Component lastComponent = null;

        // LOOP ONLY FOR LABELS
        for (int i = 0; i < loanKeys.length; i++) {
            JLabel keyLabel = new JLabel(loanKeys[i]);
            keyLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel valueLabel = new JLabel(applicationData[i]);
            valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));

            if (i == 0) {
                ui.setPosition(keyLabel, startX, startY, labelWidth, height);
            } else {
                ui.setPositionRelative(lastComponent, keyLabel, 0, verticalSpacing, labelWidth, height);
            }

            ui.setPositionRelative(keyLabel, valueLabel, labelWidth + 10, 0, valueWidth, height);

            displayLoanContainer.add(keyLabel);
            displayLoanContainer.add(valueLabel);
            lastComponent = keyLabel; // Keep track of the last label
        }

        // 2. CREATE BUTTONS OUTSIDE THE LOOP (Prevents duplication)
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(100, 50, 100,20);
        backBtn.addActionListener(e ->{
            Main.showPage("loanRequest");
        });
        displayLoanContainer.add(backBtn);

        JButton loanApprove = new JButton("Approve");
        JButton loanReject = new JButton("Reject");

        ui.setPositionRelative(lastComponent, loanApprove, 0, 60, 120, 40);
        ui.setPositionRelative(loanApprove, loanReject, 140, 0, 120, 40);

        loanApprove.addActionListener(e -> {
            String targetID = applicationData[0];
            double amount = Double.parseDouble(applicationData[6]); // Loan Amount
            double period = Double.parseDouble(applicationData[7]); // Loan Period (Years)

            Loan tempCalc = new Loan("", amount, 0, "PENDING", 0, 0, period, "");

            double rate = tempCalc.loanInterest(amount); // Automatically gets 0.035, 0.05, etc.
            double totalPayment = tempCalc.calculatePaymentAmount(amount, period);
            double monthly = totalPayment / (period * 12); // Calculate monthly cost

            Main.dataManager.updateData(targetID, User::getRequestLoanStatus, u -> u.setRequestLoanStatus("APPROVED"));
            Main.dataManager.addNewLoan(
                    targetID,
                    amount,
                    totalPayment,
                    "ACTIVE",
                    rate,
                    monthly,
                    period
            );
            JOptionPane.showMessageDialog(displayLoanContainer, "Loan Approved! Interest Rate: " + String.format("%.2f", (rate * 100)) + "%");
            System.out.println("Approved: " + applicationData[0]);

            Main.showPage("loanRequest");

        });

        loanReject.addActionListener(e -> {
            String targetID = applicationData[0];
            Main.dataManager.updateData(targetID, User::getRequestLoanStatus, u -> u.setRequestLoanStatus("REJECTED"));
            JOptionPane.showMessageDialog(displayLoanContainer, "Loan Rejected!");
            System.out.println("Rejected: " + applicationData[0]);

            Main.showPage("loanRequest");

        });

        displayLoanContainer.add(loanApprove);
        displayLoanContainer.add(loanReject);

        // 3. Refresh the UI
        displayLoanContainer.revalidate();
        displayLoanContainer.repaint();
    }



}
