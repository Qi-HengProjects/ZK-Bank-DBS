package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreateAccount extends JDialog {
    GUI ui = new GUI();
    List<JTextField> FieldsStatus = new ArrayList<>();

    public CreateAccount(Frame owner) {
        super(owner, "Apply Account", true);
        this.setSize(600, 650); // Increased height slightly to accommodate the new combo box
        this.setLayout(null);
        this.setTitle("Create Account");
        this.getContentPane().setBackground(Color.decode(GUI.WhiteColorCode));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        User u = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);

        if (u == null) {
            JOptionPane.showMessageDialog(this, "Session expired. Please login again.");
            this.dispose();
            return;
        }

        // Side Blue Bar
        JPanel sideBlueBar = new JPanel();
        sideBlueBar.setBackground(new Color(0, 51, 102));
        ui.setPosition(sideBlueBar, 0, 0, 50, 650);
        this.add(sideBlueBar);

        JLabel nameRegister = new JLabel("Name (as per IC) :");
        ui.setPosition(nameRegister, 80, 60, 150, 15);
        this.add(nameRegister);

        JTextField nameRegisterTextField = new JTextField(u.getName(), 15);
        nameRegisterTextField.setEditable(false);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        this.add(nameRegisterTextField);

        JLabel ICnoLabel = new JLabel("IC No. : ");
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        this.add(ICnoLabel);

        JTextField ICNoTextField = new JTextField(u.getIC_No(), 15);
        ICNoTextField.setEditable(false);
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        this.add(ICNoTextField);

        JLabel TelNoRegister = new JLabel("Tel No. :");
        ui.setPositionRelative(ICnoLabel, TelNoRegister, 0, 30, 150, 15);
        this.add(TelNoRegister);

        JTextField TelNoRegisterTextField = new JTextField(u.getTelNo(), 15);
        TelNoRegisterTextField.setEditable(false);
        ui.setPositionRelative(ICNoTextField, TelNoRegisterTextField, 0, 30, 250, 20);
        this.add(TelNoRegisterTextField);

        JLabel AddressRegister = new JLabel("Address :");
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        this.add(AddressRegister);

        JTextField AddressRegisterTextField = new JTextField(u.getAddress(), 15);
        AddressRegisterTextField.setEditable(false);
        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250, 20);
        this.add(AddressRegisterTextField);

        // --- EMPLOYMENT & INCOME FIELDS ---
        JLabel Occupation = new JLabel("Occupation: ");
        ui.setPositionRelative(AddressRegister, Occupation, 0 ,30, 150, 15);
        this.add(Occupation);

        JTextField OccupationTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, OccupationTextField, 0, 30, 250, 20);
        this.add(OccupationTextField);
        FieldsStatus.add(OccupationTextField);

        JLabel Company = new JLabel("Company: ");
        ui.setPositionRelative(Occupation, Company, 0 ,30, 150, 15);
        this.add(Company);

        JTextField CompanyTextField = new JTextField(15);
        ui.setPositionRelative(OccupationTextField, CompanyTextField, 0, 30, 250, 20);
        this.add(CompanyTextField);
        FieldsStatus.add(CompanyTextField);

        JLabel IncomeSource = new JLabel("Source of income: ");
        ui.setPositionRelative(Company, IncomeSource, 0 ,30, 150, 15);
        this.add(IncomeSource);

        JTextField IncomeSourceTextField = new JTextField(15);
        ui.setPositionRelative(CompanyTextField, IncomeSourceTextField, 0, 30, 250, 20);
        this.add(IncomeSourceTextField);
        FieldsStatus.add(IncomeSourceTextField);

        JLabel GrossIncome = new JLabel("Gross Income: ");
        ui.setPositionRelative(IncomeSource, GrossIncome, 0 ,30, 150, 15);
        this.add(GrossIncome);

        JTextField GrossIncomeTextField = new JTextField(15);
        ui.setPositionRelative(IncomeSourceTextField, GrossIncomeTextField, 0, 30, 250, 20);
        this.add(GrossIncomeTextField);
        FieldsStatus.add(GrossIncomeTextField);

        JLabel NetIncome = new JLabel("Net Income: ");
        ui.setPositionRelative(GrossIncome, NetIncome, 0 ,30, 150, 15);
        this.add(NetIncome);

        JTextField NetIncomeTextField = new JTextField(15);
        ui.setPositionRelative(GrossIncomeTextField, NetIncomeTextField, 0, 30, 250, 20);
        this.add(NetIncomeTextField);
        FieldsStatus.add(NetIncomeTextField);

        JLabel AccountTypeLabel = new JLabel("Account Type: ");
        ui.setPositionRelative(NetIncome, AccountTypeLabel, 0, 30, 150, 15);
        this.add(AccountTypeLabel);

        String[] accountTypes = {"Savings", "Current"};
        JComboBox<String> accountTypeComboBox = new JComboBox<>(accountTypes);
        ui.setPositionRelative(NetIncomeTextField, accountTypeComboBox, 0, 30, 250, 20);
        this.add(accountTypeComboBox);

        // --- DEPOSIT FIELD ---
        JLabel InitialDeposit = new JLabel("Initial Deposit: ");
        ui.setPositionRelative(AccountTypeLabel, InitialDeposit, 0 ,30, 150, 15);
        this.add(InitialDeposit);

        JTextField InitialDepositTextField = new JTextField(15);
        ui.setPositionRelative(accountTypeComboBox, InitialDepositTextField, 0, 30, 250, 20);
        this.add(InitialDepositTextField);
        FieldsStatus.add(InitialDepositTextField);

        // Apply Button
        JButton CreateButton = new JButton("Apply");
        CreateButton.setForeground(Color.BLACK);
        ui.setPosition(CreateButton, 250, 520, 100, 30);
        this.add(CreateButton);

        CreateButton.addActionListener(e -> {
            if (isAnyFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "All text fields must be filled in!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Double InitialDepositAmount = Double.parseDouble(InitialDepositTextField.getText());
                    if (InitialDepositAmount < 20) {
                        JOptionPane.showMessageDialog(this, "Minimum initial deposit of RM 20.00 is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String currentID = Main.currentSession;

                        // Save basic application details
                        Main.dataManager.updateData(currentID, User::getCompany, uObj -> uObj.setCompany(CompanyTextField.getText()));
                        Main.dataManager.updateData(currentID, User::getOccupation, uObj -> uObj.setOccupation(OccupationTextField.getText()));
                        Main.dataManager.updateData(currentID, User::getIncomeSource, uObj -> uObj.setIncomeSource(IncomeSourceTextField.getText()));
                        Main.dataManager.updateData(currentID, User::getGrossIncome, uObj -> uObj.setGrossIncome(GrossIncomeTextField.getText()));
                        Main.dataManager.updateData(currentID, User::getNetIncome, uObj -> uObj.setNetIncome(NetIncomeTextField.getText()));
                        Main.dataManager.updateData(currentID, User::getInitialDeposit, uObj -> uObj.setInitialDeposit(InitialDepositTextField.getText()));
                        String selectedType = (String) accountTypeComboBox.getSelectedItem();
                        Main.dataManager.updateData(currentID, User::getApplicationType, uObj -> uObj.setApplicationType(selectedType));
                        Main.dataManager.updateData(currentID, User::getApplicationStatus, uObj -> uObj.setApplicationStatus("PENDING"));

                        JOptionPane.showMessageDialog(this, "Application Details Saved!");
                        this.dispose();
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount!");
                }
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