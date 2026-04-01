package org.example;

import javax.swing.*;

public class admin extends JPanel {

    public admin(){
        this.setLayout(null);
        JScrollPane adminContainer1 = new JScrollPane();
        adminContainer1.setSize(500,500);

        this.add(adminContainer1);


        //make a white side bar that has Account Application and Loan Application Approval Pending
        // Enum status.. pending, approve
        //can use back the cardlayout from main
    }
}
