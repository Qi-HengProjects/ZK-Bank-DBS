package org.example;
import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    GUI ui = new GUI();
    private JLabel HelloLabel = new JLabel("Hello ");

    Image chinabackground3 = new ImageIcon("ChinaBackground3.jpg").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground3, 0, 0, getWidth(), getHeight(), this);
    }

    public Home(){
        this.setLayout(null);

        // Hello Label
        HelloLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        HelloLabel.setForeground(Color.decode(GUI.BlackColorCode));
        HelloLabel.setHorizontalAlignment((SwingConstants.CENTER));
        HelloLabel.setBounds(160, 100, 500, 100);
        this.add(HelloLabel);



        // Transfer Button
        GUI.GlassButton TransferBtn = new GUI.GlassButton("Transfer");
        ui.setPosition(TransferBtn, 70, 250, 120, 120);
        TransferBtn.addActionListener( e -> {
            Main.showPage("Transfer");
        });
        this.add(TransferBtn);

        // Loan Application Button
        GUI.GlassButton LoanApplicationBtn = new GUI.GlassButton("<html><center>Loan<br>Application</center></html>");
        ui.setPositionRelative(TransferBtn, LoanApplicationBtn, 300, 0, 120, 120);
        LoanApplicationBtn.addActionListener(e -> {
            Main.showPage("LoanApp");
        });
        this.add(LoanApplicationBtn);

        // Currency Exchange Button
        GUI.GlassButton CurrencyExchangeBtn = new GUI.GlassButton("<html><center>Currency<br>Exchange</center></html>");
        ui.setPositionRelative(LoanApplicationBtn, CurrencyExchangeBtn, 300, 0, 120, 120);
        CurrencyExchangeBtn.addActionListener(e -> {
            Main.showPage("Currency");
        });
        this.add(CurrencyExchangeBtn);


        //Create Account Button
        GUI.GlassButton createAccBtn = new GUI.GlassButton("<html><center>Create<br>Account</center></html>");
        ui.setPositionRelative(TransferBtn, createAccBtn, 0, 150, 120, 120);
        createAccBtn.addActionListener(e -> {
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new CreateAccount((Frame) parentWindow);
        });

        this.add(createAccBtn);

        //View Transactions Button
        GUI.GlassButton viewTransBtn = new GUI.GlassButton("<html><center>View<br>Transactions</center></html>");
        ui.setPositionRelative(createAccBtn, viewTransBtn, 300, 0, 120, 120);
        viewTransBtn.addActionListener(e -> {
            Main.showPage("viewStatements");
        });

        this.add(viewTransBtn);

        //View Account Button
        GUI.GlassButton viewAccBtn = new GUI.GlassButton("<html><center>View<br>Accounts</center></html>");
        ui.setPositionRelative(viewTransBtn, viewAccBtn, 300, 0, 120, 120);
        viewAccBtn.addActionListener(e -> {
            Main.showPage("viewAccounts");
        });

        this.add(viewAccBtn);
    }

    public void refresh() {
        String username = LoginPanel.UsernameValue;
        if (username != null) {
            HelloLabel.setText("<html>Hello <i>" + username + "</i></html>");
            this.revalidate();
            this.repaint();
        }
    }

    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        this.repaint();
    }
}