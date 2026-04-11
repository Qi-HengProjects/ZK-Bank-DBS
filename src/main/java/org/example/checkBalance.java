package org.example;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class checkBalance extends JPanel {

    GUI ui = new GUI();
    public checkBalance(){
        this.setLayout(null);

        //Container panel
        JPanel cbPanel = new JPanel();
        cbPanel.setPreferredSize(new Dimension(500,500));
        this.add(cbPanel);

        //check balance label
        JLabel checkBalance = new JLabel("Balance: ");
        cbPanel.add(checkBalance);

        //check balance textfield

        //interest rate label

        //interest rate textfield

        // total label

        // total textfield

        //confirm btn
        JButton confirmCheckBalance = new JButton("Confirm");


    }
}
