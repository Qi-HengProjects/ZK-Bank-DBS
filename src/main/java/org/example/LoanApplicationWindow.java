package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationWindow extends JFrame{
    public LoanApplicationWindow() {
        JPanel loanPanel = new JPanel();
        this.setTitle("Loan Application");
        this.setSize(1000,700);
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setLayout(new BorderLayout());
        loanPanel.setBackground(Color.YELLOW);



        TopBlueBar bar = new TopBlueBar();
        this.add(bar,BorderLayout.NORTH);
        bar.setVisible(true);
        this.add(loanPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
