package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JPanel{
    private DataManager dataManager;

    public LoanApplicationPanel() {

        this.setLayout(new BorderLayout());

    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}

