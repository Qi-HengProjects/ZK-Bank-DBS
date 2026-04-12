package org.example;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LoanApplicationPanel extends JPanel{
    //Var area
    GUI ui = new GUI();
    List<JTextComponent> FieldsStatus = new ArrayList<>();



    //Image background
    Image chinabackground2 = new ImageIcon("ChinaBackground2.jpg").getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground2, 0, 0, getWidth(), getHeight(), this);
    }

    public LoanApplicationPanel() {
        this.setLayout(null);
        User u = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);


        //Loan Application label (center)
        JLabel LoanApplicationLabelCenter = new JLabel("Loan Application");
        LoanApplicationLabelCenter.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics fmPlain = LoanApplicationLabelCenter.getFontMetrics(LoanApplicationLabelCenter.getFont());
        int contactUsWidth = fmPlain.stringWidth("Loan Application");
        ui.setPosition(LoanApplicationLabelCenter, 240, 100,contactUsWidth +10, 100);
        this.add(LoanApplicationLabelCenter);

        // Containing Panel
        JPanel loanContainer = new JPanel();
        loanContainer.setPreferredSize(new Dimension(800,500));
        ui.setPosition(loanContainer, 50,200,750,400);
        loanContainer.setLayout(null);
        this.add(loanContainer);

        //name registration label
        JLabel nameRegister = new JLabel("Name (as per IC) :");
        nameRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(nameRegister, 50, 60, 150, 15);
        loanContainer.add(nameRegister);

        //name registration textfield
        String currentName = u.getName();
        JTextField nameRegisterTextField = new JTextField(currentName, 15);
        nameRegisterTextField.setText(currentName);
        nameRegisterTextField.setEditable(false);
        nameRegisterTextField.setFocusable(false);
        nameRegisterTextField.setFont(new Font("Arial", Font.PLAIN, 13));

        nameRegisterTextField.setForeground(Color.BLACK);
        ui.setPositionRelative(nameRegister, nameRegisterTextField, 140, 0, 250, 20);
        loanContainer.add(nameRegisterTextField);

        //IC No. label
        JLabel ICnoLabel = new JLabel("IC No. : ");
        ICnoLabel.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(nameRegister, ICnoLabel, 0, 30, 150, 15);
        loanContainer.add(ICnoLabel);

        //ICNo. textfield
        String currentICNO = u.getIC_No();
        JTextField ICNoTextField = new JTextField(currentICNO, 15);
        ICNoTextField.setText(currentICNO);
        ICNoTextField.setEditable(false);
        ICNoTextField.setFocusable(false);

        ICNoTextField.setFont(new Font("Arial", Font.PLAIN, 13));
        ui.setPositionRelative(nameRegisterTextField, ICNoTextField, 0, 30, 250, 20);
        loanContainer.add(ICNoTextField);

        //Tel No. label
        JLabel TelNoRegister = new JLabel("Tel No. :");
        TelNoRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(ICnoLabel, TelNoRegister, 0, 30, 150, 15);
        loanContainer.add(TelNoRegister);

        //Tel No. textfield
        String currentTelNo = u.getTelNo();
        JTextField TelNoRegisterTextField = new JTextField(currentTelNo, 15);
        TelNoRegisterTextField.setText(currentTelNo);
        TelNoRegisterTextField.setEditable(false);
        TelNoRegisterTextField.setFocusable(false);

        ui.setPositionRelative(ICNoTextField, TelNoRegisterTextField, 0, 30, 250, 20);
        loanContainer.add(TelNoRegisterTextField);

        //Address label
        JLabel AddressRegister = new JLabel("Address :");
        AddressRegister.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(TelNoRegister, AddressRegister, 0, 30, 150, 15);
        loanContainer.add(AddressRegister);

        //Address textfield
        String currentAddress = u.getAddress();
        JTextField AddressRegisterTextField = new JTextField(currentAddress, 15);
        AddressRegisterTextField.setText(currentAddress);
        AddressRegisterTextField.setEditable(false);
        AddressRegisterTextField.setFocusable(false);

        ui.setPositionRelative(TelNoRegisterTextField, AddressRegisterTextField, 0, 30, 250, 20);
        loanContainer.add(AddressRegisterTextField);

        // Loan Amount Label
        JLabel loanAmt = new JLabel("Loan Amount: ");
        loanAmt.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(AddressRegister, loanAmt, 0 ,30, 150, 15);
        loanContainer.add(loanAmt);

        // Loan Amount textfield
        JTextField loanAmtTextField = new JTextField(15);
        ui.setPositionRelative(AddressRegisterTextField, loanAmtTextField, 0, 30, 250, 20);
        loanContainer.add(loanAmtTextField);
        FieldsStatus.add(loanAmtTextField);

        // Loan Period Label
        JLabel loanPeriod = new JLabel("Loan Period: ");
        loanPeriod.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(loanAmt, loanPeriod, 0 ,30, 150, 15);
        loanContainer.add(loanPeriod);

        // Loan Period textfield
        JTextField loanPeriodTextField = new JTextField(15);
        ui.setPositionRelative(loanAmtTextField, loanPeriodTextField, 0, 30, 250, 20);
        loanContainer.add(loanPeriodTextField);
        FieldsStatus.add(loanPeriodTextField);

        // Loan Purpose Label
        JLabel loanPurpose = new JLabel("Loan Purpose: ");
        loanPurpose.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(loanPeriod, loanPurpose, 0 ,30, 150, 15);
        loanContainer.add(loanPurpose);

        // Loan Purpose textArea
        JTextArea loanPurposeTextArea = new JTextArea(5,20);
        ui.setPositionRelative(loanPeriodTextField, loanPurposeTextArea, 0, 30, 250, 50);
        loanContainer.add(loanPurposeTextArea);
        FieldsStatus.add(loanPurposeTextArea);

        // Apply Button
        JButton CreateButton = new JButton("Apply");
        CreateButton.setForeground(Color.BLACK);
        ui.setPosition(CreateButton, 350, 300, 100, 30);
        loanContainer.add(CreateButton);
        CreateButton.addActionListener(e -> {
            //validator
            if (isAnyFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "All text fields must be filled in!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                //validate the data here
                String currentID = Main.currentSession;

                // FIXED: All variables now match the text field names defined above
                Main.dataManager.updateData(currentID, User::getRequestLoanAmount, uObj -> uObj.setRequestLoanAmount(loanAmtTextField.getText()));
                Main.dataManager.updateData(currentID, User::getRequestLoanPeriod, uObj -> uObj.setRequestLoanPeriod(loanPeriodTextField.getText()));
                Main.dataManager.updateData(currentID, User::getRequestLoanPurpose, uObj -> uObj.setRequestLoanPurpose(loanPurposeTextArea.getText()));

                Main.dataManager.updateData(currentID, User::getRequestLoanStatus, uObj -> uObj.setRequestLoanStatus("PENDING"));


                JOptionPane.showMessageDialog(this, "Application Details Saved!");

            }

        });





        //Scroll Panel (always below of the all the elements in the container to encompass)
        JScrollPane LA_SP = new JScrollPane(loanContainer);
        LA_SP.setSize(800, 500);
        ui.setPosition(LA_SP, 50, 200, 750, 400);

        this.add(LA_SP);






    }
    public void applyTheme() {
        // re-apply whatever colors that panel uses
        this.repaint();
    }

    private boolean isAnyFieldsEmpty() {
        for (JTextComponent field : FieldsStatus) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

