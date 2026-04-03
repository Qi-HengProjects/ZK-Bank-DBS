package org.example;

import javax.swing.*;
import java.awt.*;

public class TransferPage extends JPanel {
    GUI ui = new GUI();
    Image chinabackground5 = new ImageIcon("ChinaBackground5.jpg").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground5, 0, 0, getWidth(), getHeight(), this);
    }
    public TransferPage(){
        this.setLayout(null);

        //Glass Panel
        GUI.GlassPanel transferContainer = new GUI.GlassPanel();
        transferContainer.setSize(800, 400);
        transferContainer.setBackground(Color.decode(GUI.WhiteColorCode));
        ui.setPosition(transferContainer, 27, 200, 800, 400);
        this.add(transferContainer);

        JLabel transfer = new JLabel("Transfer");
        transfer.setFont(new Font("Arial", Font.PLAIN, 60));
        transfer.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(transfer, 300, 50, 500, 150);
        this.add(transfer);

        //Select Account Label
        JLabel selectAccount = new JLabel("Select Account: ");
        selectAccount.setFont(new Font("Arial", Font.BOLD, 20));
        selectAccount.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(selectAccount, 30, 50,300,20);
        transferContainer.add(selectAccount);

        //Select Account Dropdown box
        //Need a validate... if no account number, JOptionPane prompt to create account first.
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        //u.getCurrentAccounts().forEach(acc -> model.addElement(acc.getAccountNumber()));
        //u.getSavingsAccounts().forEach(acc -> model.addElement(acc.getAccountNumber()));
        JComboBox<String> accountBox = new JComboBox<>(model);
        String[] AccountChoices = {};
        JComboBox<String> AccountComboBox = new JComboBox<>(AccountChoices);
        ui.setPositionRelative(selectAccount, AccountComboBox, 250, 0, 200, 20);
        transferContainer.add(AccountComboBox);

        // Transfer Recipient Name Label
        JLabel transferRecipientName = new JLabel("Recipient Account: ");
        transferRecipientName.setFont(new Font("Arial", Font.BOLD, 20));
        transferRecipientName.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(selectAccount, transferRecipientName, 0, 50,300,20);
        transferContainer.add(transferRecipientName);

        // Transfer Recipient Name TextField
        JTextField transferRecipientNameTextField = new JTextField(25);
        transferRecipientNameTextField.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientName, transferRecipientNameTextField, 250, 0,200,20);
        transferContainer.add(transferRecipientNameTextField);

        // Transfer Recipient Account ID Label
        JLabel transferRecipient = new JLabel("Transaction Amount: ");
        transferRecipient.setFont(new Font("Arial", Font.BOLD, 20));
        transferRecipient.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientName, transferRecipient, 0, 50,300,20);
        transferContainer.add(transferRecipient);

        // Transfer Recipient Account ID TextField
        JTextField transferRecipientTextField = new JTextField(25);
        transferRecipientTextField.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientNameTextField, transferRecipientTextField, 0, 50,200,20);
        transferContainer.add(transferRecipientTextField);

        // Transfer amount Label
        JLabel transactionAmount = new JLabel("Transaction Amount: ");
        transactionAmount.setFont(new Font("Arial", Font.BOLD, 20));
        transactionAmount.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipient, transactionAmount, 0, 50,300,20);
        transferContainer.add(transactionAmount);

        // Transfer amount TextField
        JTextField transactionAmountTextField = new JTextField(25);
        transactionAmountTextField.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientTextField, transactionAmountTextField, 0, 50,200,20);
        transferContainer.add(transactionAmountTextField);

        // Reference Label
        JLabel reference = new JLabel("Recipient Reference: ");
        reference.setFont(new Font("Arial", Font.BOLD, 20));
        reference.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transactionAmount, reference, 0, 50,300,20);
        transferContainer.add(reference);

        // Reference TextField
        JTextArea referenceTextField = new JTextArea(5, 30);
        referenceTextField.setForeground(Color.decode(GUI.BlackColorCode));
        referenceTextField.setLineWrap(true);
        referenceTextField.setWrapStyleWord(true);
        ui.setPositionRelative(transactionAmountTextField, referenceTextField, 0, 50,300,70);
        transferContainer.add(referenceTextField);


        // Confirm Button
        JButton transferConfirmBtn = new JButton("Confirm");
        transferConfirmBtn.setFont(new Font("Arial", Font.BOLD, 15));
        transferConfirmBtn.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPosition(transferConfirmBtn, 325, 350, 150, 25);
        transferConfirmBtn.addActionListener( e -> {

        });
        transferContainer.add(transferConfirmBtn);



    }
}
