package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JPanel{
    public LoanApplicationPanel() {
        JPanel loanPanel = new JPanel();
        this.setLayout(new BorderLayout());
        loanPanel.setBackground(Color.YELLOW);

        this.add(loanPanel, BorderLayout.CENTER);
    }
}

