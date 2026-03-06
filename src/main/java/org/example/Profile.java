package org.example;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {
    GUI ui = new GUI();

    public Profile(){
        this.setLayout(null);

        //Profile Label (center)
        JLabel ProfileLabel = new JLabel("Profile");
        ProfileLabel.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics fmPlain = ProfileLabel.getFontMetrics(ProfileLabel.getFont());
        int contactUsWidth = fmPlain.stringWidth("Profile Us");
        ui.setPosition(ProfileLabel, 350, 0,contactUsWidth +10, 100);
        this.add(ProfileLabel);

    }
}
