package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Scanner;

public class LoginPage extends JFrame{
    // Create the frame (the window)
    GUI ui = new GUI();

    public LoginPage() {
        this.setSize(1000, 700);




        // wrapper for login panel 中间那个方块的背景
        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(Color.WHITE); //那个frame的背景 可以叫wrapper

        // login panel setup 那个灰色方块的setup
        JPanel loginBox = new JPanel();
        loginBox.setPreferredSize(new Dimension(400, 300));
        loginBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); // 灰色边线
        //loginBox.setBounds(50, 100, 50 ,10);
        loginBox.setLayout(null);

        //Image
        ImageIcon image = new ImageIcon("logo_Icon.jpg");
        Image logo_icon_1 = image.getImage();
        Image scaled_image= logo_icon_1.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
        ImageIcon scaled_logo_1 = new ImageIcon(scaled_image);

        JLabel logo = new JLabel(scaled_logo_1);
        logo.setForeground(Color.YELLOW);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setBounds(50, 10, 120, 100);
        loginBox.add(logo);

        //username label
        JLabel userLabel = ui.createLabel("Username :", 50, 150, 150, 10); // 把label做出来

        //password label
        JLabel passwordLabel = ui.createLabel("Password :", 50, 200, 150, 10);

        //username text field
        JTextField userTextField = ui.createTextField(15, 140, 150, 200, 20);

        //password text field
        JTextField passwordTextField = ui.createTextField(15, 140,200,200, 20);

        //Sign Up Button
        JButton SignUp_Button = ui.createButton("Sign Up", 75,240,100,30);

        //Sign In Button
        JButton SignIn_Button  = ui.createButton("Sign In",225, 240, 100, 30);

        // add elements to the gray box
        loginBox.add(userLabel);
        loginBox.add(userTextField);
        loginBox.add(passwordLabel);
        loginBox.add(passwordTextField);
        loginBox.add(SignUp_Button);
        loginBox.add(SignIn_Button);

        // Add the box to the wrapper 把刚才的灰色格子放在frame前面
        containerPanel.add(loginBox); // put the white panel inside wrapper

        TopBlueBar bar = new TopBlueBar();
        this.add(bar,BorderLayout.WEST);
        bar.setVisible(true);
        // add the top and login panel to the frame (InfoFrame) 排版
        this.add(bar, BorderLayout.WEST);
        this.add(containerPanel, BorderLayout.CENTER); //把那个wrapper放进那个frame


        this.setVisible(true);
    }
}



