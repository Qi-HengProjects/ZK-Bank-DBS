package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.DateComponentFormatter;
import java.util.Properties;
import java.time.LocalDate;
import java.time.Period;

public class SignUp extends JDialog {
    GUI ui = new GUI();
    List<JTextField> FieldsStatus = new ArrayList<>();
    UtilDateModel CalendarPop = new UtilDateModel();
    public  SignUp(Frame owner){
        super(owner, "Sign Up", true);
        this.setSize(600,600);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.decode(GUI.WhiteColorCode));

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        //Side Blue Bar
        JPanel sideBlueBar = new JPanel();
        sideBlueBar.setBackground(new Color(0, 51, 102));
        ui.setPosition(sideBlueBar, 0, 0, 50, 600);
        this.add(sideBlueBar);

        //name registration label
        JLabel nameRegister = new JLabel("Name (as per IC) :");
        nameRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(nameRegister, 80, 60, 150, 15);
        this.add(nameRegister);

        //name registration textfield
        JTextField nameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        this.add(nameRegisterTextField);
        FieldsStatus.add(nameRegisterTextField);


        //IC No. label
        JLabel ICnoLabel = new JLabel("IC No. : ");
        ICnoLabel.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        this.add(ICnoLabel);

        //ICNo. textfield
        JTextField ICNoTextField = new JTextField(15);
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        this.add(ICNoTextField);
        FieldsStatus.add(ICNoTextField);

        //DOB label
        JLabel DOBRegister = new JLabel("Date of Birth :");
        DOBRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(ICnoLabel, DOBRegister, 0, 30, 150, 25);
        this.add(DOBRegister);

        //DOB JDatePicker
        Properties p = new Properties();
        p.put("text.today","Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl CalenderPanel = new JDatePanelImpl(CalendarPop, p);
        JDatePickerImpl CalenderPicker = new JDatePickerImpl(CalenderPanel, new DateComponentFormatter());
        ui.setPositionRelative(ICNoTextField, CalenderPicker, 0, 30, 250, 30);
        this.add(CalenderPicker);


        //gender label
        JLabel genderRegister = new JLabel("Gender :");
        genderRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(DOBRegister, genderRegister, 0, 40, 150, 15);
        this.add(genderRegister);

        //gender ComboBox
        String[] GenderChoices = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(GenderChoices);
        ui.setPositionRelative(CalenderPicker, genderComboBox, 0, 40, 250,20);
        this.add(genderComboBox);
        System.out.println(genderComboBox);

        //nationality label
        JLabel nationalityRegister = new JLabel("Nationality :");
        nationalityRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(genderRegister, nationalityRegister, 0, 30, 150, 15);
        this.add(nationalityRegister);

        //nationality ComboBox
        String[] NationalityChoices = {"Malaysia","Singapore","Indonesia","Thailand","Vietnam"};
        JComboBox<String> nationalityComboBox = new JComboBox<>(NationalityChoices);
        ui.setPositionRelative(genderComboBox, nationalityComboBox, 0, 30, 250,20);
        this.add(nationalityComboBox);

        //Race label
        JLabel RaceRegister = new JLabel("Race :");
        RaceRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(nationalityRegister, RaceRegister, 0, 30, 150, 15);
        this.add(RaceRegister);

        //Race ComboBox
        String[] RaceChoices = {"Malay","Chinese","Indian","Thai","Vietnamese"};
        JComboBox<String> RaceRegisterComboBox = new JComboBox<>(RaceChoices);
        ui.setPositionRelative(nationalityComboBox, RaceRegisterComboBox, 0, 30, 250,20);
        this.add(RaceRegisterComboBox);

        //Religion label
        JLabel ReligionRegister = new JLabel("Religion :");
        ReligionRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(RaceRegister, ReligionRegister, 0, 30, 150, 15);
        this.add(ReligionRegister);

        //Religion ComboBox
        String[] ReligionChoices = {"Islam", "Christian", "Buddhist", "Taoism", "Hindu"};
        JComboBox<String> ReligionComboBox = new JComboBox<>(ReligionChoices);
        ui.setPositionRelative(RaceRegisterComboBox, ReligionComboBox, 0, 30, 250,20);
        this.add(ReligionComboBox);

        //Tel No. label
        JLabel TelNoRegister = new JLabel("Tel No. :");
        TelNoRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(ReligionRegister, TelNoRegister, 0, 30, 150, 15);
        this.add(TelNoRegister);

        //Tel No. textfield
        JTextField TelNoRegisterTextField = new JTextField(15);
        ui.setPositionRelative(ReligionComboBox, TelNoRegisterTextField, 0, 30, 250,20);
        this.add(TelNoRegisterTextField);
        FieldsStatus.add(TelNoRegisterTextField);

        //Address label
        JLabel AddressRegister = new JLabel("Address :");
        AddressRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        this.add(AddressRegister);

        //Address textfield
        JTextField AddressRegisterTextField = new JTextField(15);
        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250,20);
        this.add(AddressRegisterTextField);
        FieldsStatus.add(AddressRegisterTextField);

        //Username label
        JLabel UsernameRegister = new JLabel("Username :");
        UsernameRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(AddressRegister, UsernameRegister, 0, 30, 150, 15);
        this.add(UsernameRegister);

        //Username textfield
        JTextField UsernameRegisterTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, UsernameRegisterTextField, 0, 30, 250,20);
        this.add(UsernameRegisterTextField);
        FieldsStatus.add(UsernameRegisterTextField);

        //Password label
        JLabel PasswordRegister = new JLabel("Password :");
        PasswordRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(UsernameRegister, PasswordRegister, 0, 30, 150, 15);
        this.add(PasswordRegister);

        //Password textfield
        JTextField PasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(UsernameRegisterTextField, PasswordRegisterTextField, 0, 30, 250,20);
        this.add(PasswordRegisterTextField);
        FieldsStatus.add(PasswordRegisterTextField);

        //Confirm Password label
        JLabel ConfirmPasswordRegister = new JLabel("Confirm Password :");
        ConfirmPasswordRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(PasswordRegister, ConfirmPasswordRegister, 0, 30, 150, 15);
        this.add(ConfirmPasswordRegister);

        //Confirm Password textfield
        JTextField ConfirmPasswordRegisterTextField = new JTextField(15);
        ui.setPositionRelative(PasswordRegisterTextField, ConfirmPasswordRegisterTextField, 0, 30, 250,20);
        this.add(ConfirmPasswordRegisterTextField);
        FieldsStatus.add(ConfirmPasswordRegisterTextField);


        //Sign Up button
        JButton SignUpButtonReal = new JButton("Sign Up");
        SignUpButtonReal.setForeground(Color.BLACK);
        ui.setPosition(SignUpButtonReal, 250, 450, 100, 30);
        this.add(SignUpButtonReal);
        SignUpButtonReal.addActionListener(e -> {
            //validator
            if (isAnyFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "All text fields must be filled in!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else if (isUnderage()) {
                JOptionPane.showMessageDialog(this, "You must be at least 18 years old.", "Age Requirement", JOptionPane.WARNING_MESSAGE);
            } else if (!isValidInput(
                    nameRegisterTextField.getText(),
                    ICNoTextField.getText(),
                    TelNoRegisterTextField.getText())) {
                // message already shown inside isValidInput
            } else {
                String nameRegisterInput = nameRegisterTextField.getText();
                String IC_NoRegisterInput = ICNoTextField.getText();
                String birthdayRegisterInput = DOBRegister.getText();
                String genderComboBoxInput = (String) genderComboBox.getSelectedItem();
                String nationalityComboBoxInput = (String) nationalityComboBox.getSelectedItem();
                String RaceRegisterComboBoxInput = (String) RaceRegisterComboBox.getSelectedItem();
                String ReligionComboBoxInput = (String) ReligionComboBox.getSelectedItem();
                String TelNoRegisterInput = TelNoRegisterTextField.getText();
                String AddressRegisterInput = AddressRegisterTextField.getText();
                String UsernameRegisterInput = UsernameRegisterTextField.getText();
                String PasswordRegisterInput = PasswordRegisterTextField.getText();
                String ConfirmPasswordRegisterInput = ConfirmPasswordRegisterTextField.getText();
                Main.dataManager.SaveUser(new User(nameRegisterInput, IC_NoRegisterInput, birthdayRegisterInput,
                        genderComboBoxInput,nationalityComboBoxInput, RaceRegisterComboBoxInput, ReligionComboBoxInput,
                        TelNoRegisterInput, AddressRegisterInput, UsernameRegisterInput,PasswordRegisterInput,ConfirmPasswordRegisterInput));

                // all good, save and close
                this.dispose();
            }
            //anything else put below here
        });

        this.setVisible(true);

    }

    private boolean isValidInput(String name, String icNo, String telNo) {
        // Name should only contain letters and spaces
        if (!name.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Name must contain letters only!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // IC No should only contain digits (12 digits for Malaysian IC)
        if (!icNo.matches("[0-9]{12}")) {
            JOptionPane.showMessageDialog(this, "IC No. must be exactly 12 digits!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Tel No should only contain digits
        if (!telNo.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tel No. must contain digits only!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isAnyFieldsEmpty() {
        for (JTextField field : FieldsStatus) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        if (CalendarPop.getValue() == null) {
            return true;
        }
        return false;
    }

    private boolean isUnderage() {
        //get yr mth and day from JDatePicker
        int year = CalendarPop.getYear();
        int month = CalendarPop.getMonth() + 1;
        int day = CalendarPop.getDay();

        //Convert to a LocalDate Object
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        //Calculate the period between birth and today
        int age = Period.between(birthDate, today).getYears();
        return age < 18;

    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}