package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Scanner;

public class LoginPage extends JFrame{
    // Create the frame (the window)
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

        //username label
        JLabel userLabel = new JLabel("Username:"); // 把label做出来
        userLabel.setBounds(50,150,150,10);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        //password label
        JLabel password = new JLabel("Password :");
        password.setBounds(50,200,150,10);
        password.setFont(new Font("Arial", Font.PLAIN, 14));

        //username textfield
        JTextField userTextField = new JTextField(15);
        userTextField.setBounds(140 , 150, 200, 20);

        //password textfield
        JTextField passwordTextField = new JTextField(15);
        passwordTextField.setBounds(140,200,200,20);

        loginBox.add(userLabel);
        loginBox.add(userTextField);
        loginBox.add(password);
        loginBox.add(passwordTextField);
        // Add the box to the wrapper 把刚才的灰色格子放在frame前面
        containerPanel.add(loginBox); // put the white panel inside wrapper

        TopBlueBar bar = new TopBlueBar();
        this.add(bar,BorderLayout.NORTH);
        bar.setVisible(true);
        // add the top and login panel to the frame (InfoFrame) 排版
        this.add(bar, BorderLayout.NORTH);
        this.add(containerPanel, BorderLayout.CENTER); //把那个wrapper放进那个frame


        this.setVisible(true);
    }
}

