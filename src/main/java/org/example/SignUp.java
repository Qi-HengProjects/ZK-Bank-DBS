package org.example;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {
    GUI ui = new GUI();
    public  SignUp(){
        JFrame SignUp = new JFrame();
        SignUp.setSize(600,600);
        SignUp.setVisible(true);
        SignUp.setLayout(null);

        JPanel sideBlueBar = new JPanel();
        sideBlueBar.setBackground(new Color(0, 51, 102));
        ui.setPosition(sideBlueBar, 0, 0, 50, 600);
        SignUp.add(sideBlueBar);

        JLabel userRegister = new JLabel("Username :");
        ui.setPosition(userRegister, 80, 60, 150, 15);
        SignUp.add(userRegister);

        JLabel passwordRegister = new JLabel("Password :");
        ui.setPositionRelative(userRegister, passwordRegister, 0, 30, 150, 15);
        SignUp.add(passwordRegister);

        JLabel idRegister = new JLabel("Identity number :");
        ui.setPositionRelative(passwordRegister, idRegister, 0, 30, 150, 15);
        SignUp.add(idRegister);

        JTextField userRegisterTextField = new JTextField(15);
        ui.setPositionRelative(userRegister, userRegisterTextField, 140, 0, 250, 20);
        SignUp.add(userRegisterTextField);

        JTextField passwordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(userRegisterTextField, passwordRegisterTextField, 0, 30, 250, 20);
        SignUp.add(passwordRegisterTextField);

        JTextField idRegisterTextField = new JTextField(15);
        ui.setPositionRelative(passwordRegisterTextField, idRegisterTextField, 0, 30, 250, 20);
        SignUp.add(idRegisterTextField);


    }

}
