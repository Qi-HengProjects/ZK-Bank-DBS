package org.example;

import javax.swing.*;
import java.awt.*;

public class transferPage extends JPanel {
    GUI ui = new GUI();
    Image chinabackground5 = new ImageIcon("ChinaBackground5.jpg").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground5, 0, 0, getWidth(), getHeight(), this);
    }
    public transferPage(){
        this.setLayout(null);


        JLabel transfer = new JLabel("Transfer");
        transfer.setFont(new Font("Arial", Font.PLAIN, 60));
        transfer.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(transfer, 300, 50, 500, 150);
        this.add(transfer);

        //Select Account Dropdown box
    }
}
