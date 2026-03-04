package org.example;
import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    GUI ui = new GUI();

    public Home(){
        this.setLayout(new BorderLayout());











    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}
