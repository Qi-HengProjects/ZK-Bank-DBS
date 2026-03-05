package org.example;

import javax.swing.*;
import java.awt.*;

public class Contact extends JPanel{
    Image chinabackground4 = new ImageIcon("ChinaBackground4.jpg").getImage();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground4, 0, 0, getWidth(), getHeight(), this);
    }
    public Contact(){

    }

}
