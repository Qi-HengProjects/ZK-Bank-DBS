package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
        transferContainer.setSize(800, 450);
        transferContainer.setBackground(Color.decode(GUI.WhiteColorCode));
        ui.setPosition(transferContainer, 27, 200, 800, 450);
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
        User u = (User) Main.dataManager.search("Users", Main.currentSession, null, null, null);
        //Need a validate... if no account number, JOptionPane prompt to create account first.
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        if (u != null) {
            for (SavingsAccount sa : u.getSavingsAccounts()) {
                model.addElement(sa.getAccountNumber() + " (Savings)");
            }
            for (CurrentAccount ca : u.getCurrentAccounts()) {
                model.addElement(ca.getAccountNumber() + " (Current)");
            }
        }

        JComboBox<String> AccountComboBox = new JComboBox<>(model);
        ui.setPositionRelative(selectAccount, AccountComboBox, 250, 0, 200, 20);
        transferContainer.add(AccountComboBox);

        //Transfer Recipient Bank Label
        JLabel transferRecipientBank = new JLabel("Bank: ");
        transferRecipientBank.setFont(new Font("Arial", Font.BOLD, 20));
        transferRecipientBank.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(selectAccount, transferRecipientBank, 0, 50, 300, 20);
        transferContainer.add(transferRecipientBank);

        //Transfer Recipient Bank ComboBox
        String[] BankChoices = {"ZhaKai Bank", "Others"};
        JComboBox<String> bankComboBox = new JComboBox<>(BankChoices);
        ui.setPositionRelative(AccountComboBox, bankComboBox, 0, 40, 200, 20);
        transferContainer.add(bankComboBox);


        // Transfer Recipient Name Label
        JLabel transferRecipientName = new JLabel("Recipient Name: ");
        transferRecipientName.setFont(new Font("Arial", Font.BOLD, 20));
        transferRecipientName.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientBank, transferRecipientName, 0, 50,300,20);
        transferContainer.add(transferRecipientName);

        // Transfer Recipient Name TextField
        JTextField transferRecipientNameTextField = new JTextField(25);
        transferRecipientNameTextField.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(transferRecipientName, transferRecipientNameTextField, 250, 0,200,20);
        transferContainer.add(transferRecipientNameTextField);

        // Transfer Recipient Account ID Label
        JLabel transferRecipient = new JLabel("Recipient Account: ");
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
        JTextArea referenceTextField = new JTextArea(3, 30);
        referenceTextField.setForeground(Color.decode(GUI.BlackColorCode));
        referenceTextField.setLineWrap(true);
        referenceTextField.setWrapStyleWord(true);
        ui.setPositionRelative(transactionAmountTextField, referenceTextField, 0, 50,300,70);
        transferContainer.add(referenceTextField);


        // Confirm Button
        JButton transferConfirmBtn = new JButton("Confirm");
        transferConfirmBtn.setFont(new Font("Arial", Font.BOLD, 15));
        transferConfirmBtn.setForeground(Color.decode(GUI.BlackColorCode));
        ui.setPositionRelative(reference, transferConfirmBtn, 0, 100, 150, 25);
        transferContainer.add(transferConfirmBtn);
        transferConfirmBtn.addActionListener(e -> {
            try {
                if (AccountComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this, "You must select a source account first!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // 1. Get inputs from GUI
                String selectedAcc = (String) AccountComboBox.getSelectedItem();
                String senderAccNum = selectedAcc.split(" ")[0]; // Extract the number
                String targetBank = (String) bankComboBox.getSelectedItem();
                String recipientAcc = transferRecipientTextField.getText();
                double amount = Double.parseDouble(transactionAmountTextField.getText());

                // 2. Branch logic based on Bank selection
                if (targetBank.equals("ZhaKai Bank")) {
                    // Use your existing internal transfer method
                    boolean thisTransaction = Main.dataManager.performTransfer(senderAccNum, recipientAcc, amount);
                    if (thisTransaction) {
                        JOptionPane.showMessageDialog(this, "Transfer Successful!");
                        Main.showPage("Home");
                    } else {
                        JOptionPane.showMessageDialog(this, "Transfer Failed!");
                        Main.showPage("Home");
                    }

                } else {
                    // Use the new external transfer method we created
                    boolean thisExternalTransaction = Main.dataManager.performExternalTransfer(senderAccNum, amount, targetBank, recipientAcc);

                    if (thisExternalTransaction) {
                        JOptionPane.showMessageDialog(this, "Transfer Successful!");
                        Main.showPage("Home");
                    } else {
                        JOptionPane.showMessageDialog(this, "Transfer Failed!");
                        Main.showPage("Home");

                    }

                }


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            Main.showPage("Home");
            for (Component c : Main.mainPanel.getComponents()) {
                if (c instanceof Home) {
                    ((Home) c).refresh();
                    break;
                }
            }
        });

    }
}


