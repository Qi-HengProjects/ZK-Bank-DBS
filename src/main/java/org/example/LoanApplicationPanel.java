package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JPanel{
    private DataManager dataManager;
    Image chinabackground2 = new ImageIcon("ChinaBackground2.jpg").getImage();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground2, 0, 0, getWidth(), getHeight(), this);
    }

    public LoanApplicationPanel() {

        this.setLayout(new BorderLayout());













    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}

