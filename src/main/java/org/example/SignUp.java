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

        //Side Blue Bar
        JPanel sideBlueBar = new JPanel();
        sideBlueBar.setBackground(new Color(0, 51, 102));
        ui.setPosition(sideBlueBar, 0, 0, 50, 600);
        SignUp.add(sideBlueBar);

        //name registration label
        JLabel nameRegister = new JLabel("Name (as per IC) :");
        ui.setPosition(nameRegister, 80, 60, 150, 15);
        SignUp.add(nameRegister);

        //name registration textfield
        JTextField nameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        SignUp.add(nameRegisterTextField);

        //IC No. label
        JLabel ICnoLabel = new JLabel("IC No. : ");
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        SignUp.add(ICnoLabel);

        //ICNo. textfield
        JTextField ICNoTextField = new JTextField(15);
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        SignUp.add(ICNoTextField);

        //DOB label
        JLabel DOBRegister = new JLabel("Date of Birth :");
        ui.setPositionRelative(ICnoLabel, DOBRegister, 0, 30, 150, 15);
        SignUp.add(DOBRegister);

        //DOB textfield
        JTextField DOBRegisterTextField = new JTextField(15);
        ui.setPositionRelative(ICNoTextField, DOBRegisterTextField, 0, 30, 250, 20); //fix
        SignUp.add(DOBRegisterTextField);

        //gender label
        JLabel genderRegister = new JLabel("Gender :");
        ui.setPositionRelative(DOBRegister, genderRegister, 0, 30, 150, 15);
        SignUp.add(genderRegister);

        //gender ComboBox
        String[] GenderChoices = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(GenderChoices);
        ui.setPositionRelative(DOBRegisterTextField, genderComboBox, 0, 30, 250,20);
        SignUp.add(genderComboBox);

        //nationality label
        JLabel nationalityRegister = new JLabel("Nationality :");
        ui.setPositionRelative(genderRegister, nationalityRegister, 0, 30, 150, 15);
        SignUp.add(nationalityRegister);

        //nationality ComboBox
        String[] NationalityChoices = {"Malaysia","Singapore","Indonesia","Thailand","Vietnam"};
        JComboBox<String> nationalityComboBox = new JComboBox<>(NationalityChoices);
        ui.setPositionRelative(genderComboBox, nationalityComboBox, 0, 30, 250,20);
        SignUp.add(nationalityComboBox);

        //Race label
        JLabel RaceRegister = new JLabel("Race :");
        ui.setPositionRelative(nationalityRegister, RaceRegister, 0, 30, 150, 15);
        SignUp.add(RaceRegister);

        //Race ComboBox
        String[] RaceChoices = {"Malay","Chinese","Indian","Thai","Vietnamese"};
        JComboBox<String> RaceRegisterComboBox = new JComboBox<>(RaceChoices);
        ui.setPositionRelative(nationalityComboBox, RaceRegisterComboBox, 0, 30, 250,20);
        SignUp.add(RaceRegisterComboBox);

        //Religion label
        JLabel ReligionRegister = new JLabel("Religion :");
        ui.setPositionRelative(RaceRegister, ReligionRegister, 0, 30, 150, 15);
        SignUp.add(ReligionRegister);

        //Religion textfield
        JTextField ReligionRegisterTextField = new JTextField(15);
        ui.setPositionRelative(RaceRegisterComboBox, ReligionRegisterTextField, 0, 30, 250,20);
        SignUp.add(ReligionRegisterTextField);

        //Tel No. label
        JLabel TelNoRegister = new JLabel("Tel No. :");
        ui.setPositionRelative(ReligionRegister, TelNoRegister, 0, 30, 150, 15);
        SignUp.add(TelNoRegister);

        //Tel No. textfield
        JTextField TelNoRegisterTextField = new JTextField(15);
        ui.setPositionRelative(ReligionRegisterTextField, TelNoRegisterTextField, 0, 30, 250,20);
        SignUp.add(TelNoRegisterTextField);

        //Address label
        JLabel AddressRegister = new JLabel("Address :");
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        SignUp.add(AddressRegister);

        //Address textfield
        JTextField AddressRegisterTextField = new JTextField(15);
        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250,20);
        SignUp.add(AddressRegisterTextField);

        //Username label
        JLabel UsernameRegister = new JLabel("Username :");
        ui.setPositionRelative(AddressRegister, UsernameRegister, 0, 30, 150, 15);
        SignUp.add(UsernameRegister);

        //Username textfield
        JTextField UsernameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, UsernameRegisterTextField, 0, 30, 250,20);
        SignUp.add(UsernameRegisterTextField);

        //Password label
        JLabel PasswordRegister = new JLabel("Password :");
        ui.setPositionRelative(UsernameRegister, PasswordRegister, 0, 30, 150, 15);
        SignUp.add(PasswordRegister);

        //Password textfield
        JTextField PasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(UsernameRegisterTextField, PasswordRegisterTextField, 0, 30, 250,20);
        SignUp.add(PasswordRegisterTextField);

        //Confirm Password label
        JLabel ConfirmPasswordRegister = new JLabel("Confirm Password :");
        ui.setPositionRelative(PasswordRegister, ConfirmPasswordRegister, 0, 30, 150, 15);
        SignUp.add(ConfirmPasswordRegister);

        //Confirm Password textfield
        JTextField ConfirmPasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(PasswordRegisterTextField, ConfirmPasswordRegisterTextField, 0, 30, 250,20);
        SignUp.add(ConfirmPasswordRegisterTextField);

        //Sign Up button
        JButton SignUpButtonReal = new JButton("Sign Up");
        ui.setPosition(SignUpButtonReal, 250, 450, 100, 30);
        SignUp.add(SignUpButtonReal);






    }

}
