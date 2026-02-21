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

        //Next to icon label (ZK BANK)
        JLabel ZKBank = new JLabel("ZK BANK");
        ZKBank.setFont(new Font("Arial", Font.BOLD, 30));
        ZKBank.setBounds(190, 40, 300, 50);
        loginBox.add(ZKBank);

        //username label
        JLabel userLabel = new JLabel("Username:"); // 把label做出来
        userLabel.setBounds(50,150,150,10);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        loginBox.add(userLabel);

        //password label
        JLabel password = new JLabel("Password :");
        password.setBounds(50,200,150,10);
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        loginBox.add(password);

        //username textfield
        JTextField userTextField_S = new JTextField(15);
        userTextField_S.setBounds(140 , 150, 200, 20);
        loginBox.add(userTextField_S);

        //password textfield
        JTextField passwordTextField_S = new JTextField(15);
        passwordTextField_S.setBounds(140,200,200,20);
        loginBox.add(passwordTextField_S);

        //Log In Button
        JButton LogIn_Button = new JButton("Log In");
        LogIn_Button.setBounds(150,240,100,30);
        loginBox.add(LogIn_Button);

        //Sign Up Button
        JButton SignUp_Button = new JButton("<html><u>Sign Up?</u></html>");
        SignUp_Button.setFont(new Font("Arial",Font.ITALIC, 15));
        SignUp_Button.setBorderPainted(false);
        SignUp_Button.setContentAreaFilled(false);
        SignUp_Button.setFocusPainted(false);
        SignUp_Button.setForeground(Color.BLUE);
        SignUp_Button.setBounds(20,260,100,30);
        loginBox.add(SignUp_Button);
        //Pop to Sign Up pop up window
        SignUp_Button.addActionListener( e -> {
            new SignUp();

        });


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




