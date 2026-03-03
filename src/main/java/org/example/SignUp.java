package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends JDialog {
    GUI ui = new GUI();
    List<JTextField> FieldsStatus = new ArrayList<>();
    public  SignUp(Frame owner){
        super(owner, "Sign Up", true);
        this.setSize(600,600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //Side Blue Bar
        JPanel sideBlueBar = new JPanel();
        sideBlueBar.setBackground(new Color(0, 51, 102));
        ui.setPosition(sideBlueBar, 0, 0, 50, 600);
        this.add(sideBlueBar);

        //name registration label
        JLabel nameRegister = new JLabel("Name (as per IC) :");
        ui.setPosition(nameRegister, 80, 60, 150, 15);
        this.add(nameRegister);

        //name registration textfield
        JTextField nameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        this.add(nameRegisterTextField);
        FieldsStatus.add(nameRegisterTextField);

        //IC No. label
        JLabel ICnoLabel = new JLabel("IC No. : ");
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        this.add(ICnoLabel);

        //ICNo. textfield
        JTextField ICNoTextField = new JTextField(15);
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        this.add(ICNoTextField);
        FieldsStatus.add(ICNoTextField);

        //DOB label
        JLabel DOBRegister = new JLabel("Date of Birth :");
        ui.setPositionRelative(ICnoLabel, DOBRegister, 0, 30, 150, 15);
        this.add(DOBRegister);

        //DOB textfield
        JTextField DOBRegisterTextField = new JTextField(15);
        ui.setPositionRelative(ICNoTextField, DOBRegisterTextField, 0, 30, 250, 20); //fix
        this.add(DOBRegisterTextField);
        FieldsStatus.add(DOBRegisterTextField);

        //gender label
        JLabel genderRegister = new JLabel("Gender :");
        ui.setPositionRelative(DOBRegister, genderRegister, 0, 30, 150, 15);
        this.add(genderRegister);

        //gender ComboBox
        String[] GenderChoices = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(GenderChoices);
        ui.setPositionRelative(DOBRegisterTextField, genderComboBox, 0, 30, 250,20);
        this.add(genderComboBox);

        //nationality label
        JLabel nationalityRegister = new JLabel("Nationality :");
        ui.setPositionRelative(genderRegister, nationalityRegister, 0, 30, 150, 15);
        this.add(nationalityRegister);

        //nationality ComboBox
        String[] NationalityChoices = {"Malaysia","Singapore","Indonesia","Thailand","Vietnam"};
        JComboBox<String> nationalityComboBox = new JComboBox<>(NationalityChoices);
        ui.setPositionRelative(genderComboBox, nationalityComboBox, 0, 30, 250,20);
        this.add(nationalityComboBox);

        //Race label
        JLabel RaceRegister = new JLabel("Race :");
        ui.setPositionRelative(nationalityRegister, RaceRegister, 0, 30, 150, 15);
        this.add(RaceRegister);

        //Race ComboBox
        String[] RaceChoices = {"Malay","Chinese","Indian","Thai","Vietnamese"};
        JComboBox<String> RaceRegisterComboBox = new JComboBox<>(RaceChoices);
        ui.setPositionRelative(nationalityComboBox, RaceRegisterComboBox, 0, 30, 250,20);
        this.add(RaceRegisterComboBox);

        //Religion label
        JLabel ReligionRegister = new JLabel("Religion :");
        ui.setPositionRelative(RaceRegister, ReligionRegister, 0, 30, 150, 15);
        this.add(ReligionRegister);

        //Religion textfield
        JTextField ReligionRegisterTextField = new JTextField(15);
        ui.setPositionRelative(RaceRegisterComboBox, ReligionRegisterTextField, 0, 30, 250,20);
        this.add(ReligionRegisterTextField);
        FieldsStatus.add(ReligionRegisterTextField);

        //Tel No. label
        JLabel TelNoRegister = new JLabel("Tel No. :");
        ui.setPositionRelative(ReligionRegister, TelNoRegister, 0, 30, 150, 15);
        this.add(TelNoRegister);

        //Tel No. textfield
        JTextField TelNoRegisterTextField = new JTextField(15);
        ui.setPositionRelative(ReligionRegisterTextField, TelNoRegisterTextField, 0, 30, 250,20);
        this.add(TelNoRegisterTextField);
        FieldsStatus.add(TelNoRegisterTextField);

        //Address label
        JLabel AddressRegister = new JLabel("Address :");
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        this.add(AddressRegister);

        //Address textfield
        JTextField AddressRegisterTextField = new JTextField(15);
        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250,20);
        this.add(AddressRegisterTextField);
        FieldsStatus.add(AddressRegisterTextField);

        //Username label
        JLabel UsernameRegister = new JLabel("Username :");
        ui.setPositionRelative(AddressRegister, UsernameRegister, 0, 30, 150, 15);
        this.add(UsernameRegister);

        //Username textfield
        JTextField UsernameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, UsernameRegisterTextField, 0, 30, 250,20);
        this.add(UsernameRegisterTextField);
        FieldsStatus.add(UsernameRegisterTextField);

        //Password label
        JLabel PasswordRegister = new JLabel("Password :");
        ui.setPositionRelative(UsernameRegister, PasswordRegister, 0, 30, 150, 15);
        this.add(PasswordRegister);

        //Password textfield
        JTextField PasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(UsernameRegisterTextField, PasswordRegisterTextField, 0, 30, 250,20);
        this.add(PasswordRegisterTextField);
        FieldsStatus.add(PasswordRegisterTextField);

        //Confirm Password label
        JLabel ConfirmPasswordRegister = new JLabel("Confirm Password :");
        ui.setPositionRelative(PasswordRegister, ConfirmPasswordRegister, 0, 30, 150, 15);
        this.add(ConfirmPasswordRegister);

        //Confirm Password textfield
        JTextField ConfirmPasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(PasswordRegisterTextField, ConfirmPasswordRegisterTextField, 0, 30, 250,20);
        this.add(ConfirmPasswordRegisterTextField);
        FieldsStatus.add(ConfirmPasswordRegisterTextField);


        //Sign Up button
        JButton SignUpButtonReal = new JButton("Sign Up");
        ui.setPosition(SignUpButtonReal, 250, 450, 100, 30);
        this.add(SignUpButtonReal);
        SignUpButtonReal.addActionListener(e ->{
            //Write Data and return to Login Page
            if (isAnyFieldsEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "All text fields must be filled in!",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                this.dispose();
            }

        });
        this.setVisible(true);

    }

    private boolean isAnyFieldsEmpty() {
        for (JTextField field : FieldsStatus) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }


}
