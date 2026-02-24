package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JFrame{
    public LoanApplicationPanel() {
        JPanel loanPanel = new JPanel();
        this.setTitle("Loan Application");
        this.setSize(1000,700);
        this.setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
        this.setLayout(new BorderLayout());
        loanPanel.setBackground(Color.YELLOW);



        TopBlueBar bar = new TopBlueBar();
        this.add(bar,BorderLayout.WEST);
        bar.setVisible(true);
        this.add(loanPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}

