package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JPanel{
    //Var area
    private DataManager dataManager;
    GUI ui = new GUI();

    //Image background
    Image chinabackground2 = new ImageIcon("ChinaBackground2.jpg").getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground2, 0, 0, getWidth(), getHeight(), this);
    }

    public LoanApplicationPanel() {
        this.setLayout(null);

        //Loan Application label (center)
        JLabel LoanApplicationLabelCenter = new JLabel("Loan Application");
        LoanApplicationLabelCenter.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics fmPlain = LoanApplicationLabelCenter.getFontMetrics(LoanApplicationLabelCenter.getFont());
        int contactUsWidth = fmPlain.stringWidth("Loan Application");
        ui.setPosition(LoanApplicationLabelCenter, 300, 100,contactUsWidth +10, 100);
        this.add(LoanApplicationLabelCenter);




    }
    public void applyTheme() {
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}

