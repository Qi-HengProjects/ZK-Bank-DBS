package org.example;

import javax.swing.*;
import java.awt.*;

public class LoanApplicationPanel extends JPanel{
    //Var area
    private DataManager dataManager;
    GUI ui = new GUI();

    //Image background
    Image chinabackground2 = new ImageIcon("ChinaBackground2.jpg").getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground2, 0, 0, getWidth(), getHeight(), this);
    }

    public LoanApplicationPanel() {
        this.setLayout(null);
        User u = (User) Main.dataManager.search("Users", Main.currentSession, null, null);


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
        ui.setPosition(nameRegister, 80, 60, 150, 15);
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
}

