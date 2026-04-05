package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Admin extends JPanel {


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


            List<String[]> accountApplicationList = Main.dataManager.makeAccountApplicationList();
            if (accountApplicationList != null) {
                for (String[] applications : accountApplicationList) {
                    if (applications != null) {

                        //display the things here
                        // Frontend logic for the for each loop in the request array
                        // Display as long buttons without borders
                        // array for each into the ui element
                        // use setPositionRelative for automated position (in the for each loop)
                        //@jayden done with the admin page then only we can continue with the approval button logic
                    }
                }
            } else {
                JLabel nothingHereLabel = new JLabel("No requests!");
                nothingHereLabel.setFont(new Font("Arial", Font.BOLD,20));
                ui.setPosition(nothingHereLabel, 450, 315, 100, 20);
                adminContainer1.add(nothingHereLabel);
            }


            // Approve Account Btn
            JButton accountApprove = new JButton("Approve");
            ui.setPosition(accountApprove, 400, 400, 100, 50);
            accountApprove.addActionListener( e -> {

                //Main.dataManager.updateData(, User::getApplicationStatus, uObj -> uObj.setApplicationStatus("APPROVED"));
                //Main.dataManager.addNewAccount();
            });
            this.add(accountApprove);

            // Reject Account Btn
            JButton accountReject = new JButton("Reject");
            ui.setPosition(accountReject, 600, 400, 100, 50);
            accountReject.addActionListener( e -> {

            });
            this.add(accountReject);


            // Wrap contentPanel in scrollpane
            JScrollPane scrollPane = new JScrollPane(adminContainer1);
            scrollPane.setBounds(0, 0, 1000, 650);
            this.add(scrollPane); // scrollPane goes on the page
        }
    }
//make a white side bar that has Account Application and Loan Application Approval Pending
    // Enum status.. pending, approve
    //can use back the cardlayout from main

    public static class newLoanRequest extends JPanel{
        GUI ui = new GUI();

        public newLoanRequest(){
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000, 650));

            // This is where all your content goes
            JPanel adminContainer2 = new JPanel();
            adminContainer2.setLayout(null);
            adminContainer2.setPreferredSize(new Dimension(1000, 2000)); // tall enough to scroll

            // Add everything to contentPanel, NOT to this
            JLabel accountRequestTitle = new JLabel("Loan Request");
            accountRequestTitle.setFont(new Font("Arial", Font.BOLD, 30));
            accountRequestTitle.setBounds(200, 50, 300, 50);
            adminContainer2.add(accountRequestTitle); // <-- contentPanel, not this

            // Approve Loan Btn
            JButton loanApprove = new JButton("Approve");
            ui.setPosition(loanApprove, 400, 400, 100, 50);
            loanApprove.addActionListener( e -> {
                //Main.dataManager.updateData(something, User::getRequestLoanStatus, uObj -> uObj.setRequestLoanStatus("APPROVED")); @Qi Heng add the approve logic here                      <-------------------@Qi Heng
                //@jayden put a refresh here so the page will change
            });
            this.add(loanApprove);

            // Reject Loan Btn
            JButton loanReject = new JButton("Reject");
            ui.setPosition(loanReject, 600, 400, 100, 50);
            loanReject.addActionListener( e -> {
                //Main.dataManager.updateData(something, User::getRequestLoanStatus, uObj -> uObj.setRequestLoanStatus("DENIED")); @Qi Heng add the reject logic here                      <-------------------@Qi Heng
                //@jayden put a refresh here so the page will change
            });
            this.add(loanReject);

            // Wrap contentPanel in scrollpane
            JScrollPane scrollPane = new JScrollPane(adminContainer2);
            scrollPane.setBounds(0, 0, 1000, 650);
            this.add(scrollPane); // scrollPane goes on the page
        }
    }
}
