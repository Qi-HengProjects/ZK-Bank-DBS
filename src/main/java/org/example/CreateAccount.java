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

public class CreateAccount extends JDialog {
    GUI ui = new GUI();
    List<JTextField> FieldsStatus = new ArrayList<>();
    UtilDateModel CalendarPop = new UtilDateModel();

    public CreateAccount(Frame owner) {
        super(owner, "Apply Account", true);
        this.setSize(600, 600);
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
        User u = (User) Main.currentObject;
        String currentName = u.getName();
        JTextField nameRegisterTextField = new JTextField(currentName, 15);
        nameRegisterTextField.setEditable(false);
        nameRegisterTextField.setFocusable(false);
        nameRegisterTextField.setFont(new Font("Arial", Font.PLAIN, 13));

        nameRegisterTextField.setForeground(Color.BLACK);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        this.add(nameRegisterTextField);
        FieldsStatus.add(nameRegisterTextField);

        //IC No. label
        JLabel ICnoLabel = new JLabel("IC No. : ");
        ICnoLabel.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        this.add(ICnoLabel);

        //ICNo. textfield
        String currentICNO = u.getIC_No();
        JTextField ICNoTextField = new JTextField(currentICNO, 15);
        ICNoTextField.setEditable(false);
        ICNoTextField.setFocusable(false);

        ICNoTextField.setFont(new Font("Arial", Font.PLAIN, 13));
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        this.add(ICNoTextField);
        FieldsStatus.add(ICNoTextField);

        //Tel No. label
        JLabel TelNoRegister = new JLabel("Tel No. :");
        TelNoRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(ICnoLabel, TelNoRegister, 0, 30, 150, 15);
        this.add(TelNoRegister);

        //Tel No. textfield
        String currentTelNo = u.getTelNo();
        JTextField TelNoRegisterTextField = new JTextField(currentTelNo, 15);
        TelNoRegisterTextField.setEditable(false);
        TelNoRegisterTextField.setFocusable(false);

        ui.setPositionRelative(ICNoTextField, TelNoRegisterTextField, 0, 30, 250, 20);
        this.add(TelNoRegisterTextField);
        FieldsStatus.add(TelNoRegisterTextField);

        //Address label
        JLabel AddressRegister = new JLabel("Address :");
        AddressRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        this.add(AddressRegister);

        //Address textfield
        String currentAddress = u.getAddress();
        JTextField AddressRegisterTextField = new JTextField(currentAddress, 15);
        AddressRegisterTextField.setEditable(false);
        AddressRegisterTextField.setFocusable(false);

        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250, 20);
        this.add(AddressRegisterTextField);
        FieldsStatus.add(AddressRegisterTextField);

        //occupation label
        JLabel Occupation = new JLabel("Occupation: ");
        Occupation.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(AddressRegister, Occupation, 0 ,30, 150, 15);
        this.add(Occupation);

        //occupation textfield
        JTextField OccupationTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, OccupationTextField, 0, 30, 250, 20);
        this.add(OccupationTextField);
        FieldsStatus.add(OccupationTextField);

        //Company label
        JLabel Company = new JLabel("Company: ");
        Company.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(Occupation, Company, 0 ,30, 150, 15);
        this.add(Company);

        //Company textfield
        JTextField CompanyTextField = new JTextField(15);
        ui.setPositionRelative(OccupationTextField, CompanyTextField, 0, 30, 250, 20);
        this.add(CompanyTextField);
        FieldsStatus.add(CompanyTextField);

        //source of income label
        JLabel IncomeSource = new JLabel("Source of income: ");
        IncomeSource.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(Company, IncomeSource, 0 ,30, 150, 15);
        this.add(IncomeSource);

        //source of income textfield
        JTextField IncomeSourceTextField = new JTextField(15);
        ui.setPositionRelative(CompanyTextField, IncomeSourceTextField, 0, 30, 250, 20);
        this.add(IncomeSourceTextField);
        FieldsStatus.add(IncomeSourceTextField);

        //gross income label
        JLabel GrossIncome = new JLabel("Gross Income: ");
        GrossIncome.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(IncomeSource, GrossIncome, 0 ,30, 150, 15);
        this.add(GrossIncome);

        //gross income textfield
        JTextField GrossIncomeTextField = new JTextField(15);
        ui.setPositionRelative(IncomeSourceTextField, GrossIncomeTextField, 0, 30, 250, 20);
        this.add(GrossIncomeTextField);
        FieldsStatus.add(GrossIncomeTextField);

        //net income label
        JLabel NetIncome = new JLabel("Net Income: ");
        NetIncome.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(GrossIncome, NetIncome, 0 ,30, 150, 15);
        this.add(NetIncome);

        //net income textfield
        JTextField NetIncomeTextField = new JTextField(15);
        ui.setPositionRelative(GrossIncomeTextField, NetIncomeTextField, 0, 30, 250, 20);
        this.add(NetIncomeTextField);
        FieldsStatus.add(NetIncomeTextField);






        //Create Acc Button
        JButton CreateButton = new JButton("Apply");
        CreateButton.setForeground(Color.BLACK);
        ui.setPosition(CreateButton, 250, 450, 100, 30);
        this.add(CreateButton);
        CreateButton.addActionListener(e -> {
            //validator
            if (isAnyFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "All text fields must be filled in!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else if (isUnderage()) {
                JOptionPane.showMessageDialog(this, "You must be at least 18 years old.", "Age Requirement", JOptionPane.WARNING_MESSAGE);
            } else if (!isValidInput(nameRegisterTextField.getText(), ICNoTextField.getText(), TelNoRegisterTextField.getText())) {
            } else {
                //validate the data here
                //@Qi Heng fix this part to save into current user not make new user.
                /*String OccupationRegisterInput = OccupationTextField.getText();
                String CompanyRegisterInput = CompanyTextField.getText();
                String IncomeSourceRegisterInput = IncomeSourceTextField.getText();
                String GrossIncomeRegisterInput = GrossIncomeTextField.getText();
                String NetIncomeRegisterInput = NetIncomeTextField.getText();

                Main.dataManager.SaveUser(new User(OccupationRegisterInput, CompanyRegisterInput,
                        IncomeSourceRegisterInput, GrossIncomeRegisterInput, NetIncomeRegisterInput));

                 */

                this.dispose();
            }

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
        return CalendarPop.getValue() == null;
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

}