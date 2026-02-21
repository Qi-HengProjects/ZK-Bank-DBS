package org.example;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {
    public  SignUp(){
        JFrame SignUp = new JFrame("Sign Up");
        SignUp.setSize(400,400);
        SignUp.setBackground(Color.GRAY);
        SignUp.setVisible(true);


        SignUp.setLayout(null);

        //Image
        ImageIcon image = new ImageIcon("logo_Icon.jpg");
        Image logo_icon_1 = image.getImage();
        Image scaled_image= logo_icon_1.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
        ImageIcon scaled_logo_1 = new ImageIcon(scaled_image);

        JLabel logo = new JLabel(scaled_logo_1);
        logo.setForeground(Color.YELLOW);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setBounds(50, 10, 120, 100);
        SignUp.add(logo);

        //Next to icon label (ZK BANK)
        JLabel ZKBank = new JLabel("ZK BANK");
        ZKBank.setFont(new Font("Arial", Font.BOLD, 30));
        ZKBank.setBounds(190, 40, 300, 50);
        SignUp.add(ZKBank);

        //username label
        JLabel userLabel = new JLabel("Username:"); // 把label做出来
        userLabel.setBounds(50,150,150,15);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        SignUp.add(userLabel);

        //password label
        JLabel password = new JLabel("Password :");
        password.setBounds(50,200,150,10);
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        SignUp.add(password);

        //username textfield
        JTextField userTextField_L = new JTextField(15);
        userTextField_L.setBounds(140 , 150, 200, 20);
        SignUp.add(userTextField_L);

        //password textfield
        JTextField passwordTextField_L = new JTextField(15);
        passwordTextField_L.setBounds(140,200,200,20);
        SignUp.add(passwordTextField_L);

        //Sign Up Button
        JButton SignedUp_Button = new JButton("Sign Up");
        SignedUp_Button.setBounds(150,240,100,30);
        SignUp.add(SignedUp_Button);
        SignedUp_Button.addActionListener( e -> {
            System.out.println("Waiting for file management to append in");

        });


    }

}
