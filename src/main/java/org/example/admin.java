package org.example;

import javax.swing.*;
import java.awt.*;


public class admin extends JPanel {


    public static class newAccountRequest extends JPanel {

        GUI ui = new GUI();
        public newAccountRequest() {
            this.setLayout(null);
            this.setPreferredSize(new Dimension(1000, 650));

            // This is where all your content goes
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(null);
            contentPanel.setPreferredSize(new Dimension(1000, 2000)); // tall enough to scroll

            // Add everything to contentPanel, NOT to this
            JLabel accountRequestTitle = new JLabel("Account Request");
            accountRequestTitle.setFont(new Font("Arial", Font.BOLD, 30));
            accountRequestTitle.setBounds(200, 50, 300, 50);
            contentPanel.add(accountRequestTitle); // <-- contentPanel, not this

            // Wrap contentPanel in scrollpane
            JScrollPane scrollPane = new JScrollPane(contentPanel);
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


        }
    }
}
