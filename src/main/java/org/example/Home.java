package org.example;
import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    GUI ui = new GUI();

    public Home(){
        this.setLayout(new BorderLayout());
        this.setLayout(null);

        //Hello Label
        JLabel Hello = new JLabel("Hello ");
        Hello.setFont(new Font("Arial", Font.BOLD, 100));
        ui.setPosition(Hello, 150,50,500,200);
        this.add(Hello);

        //Transfer Button
        GUI.GlassButton TransferBtn = new GUI.GlassButton("Transfer");
        ui.setPosition(TransferBtn, 80,300,100,100);
        this.add(TransferBtn);

        //Loan Application Button
        GUI.GlassButton LoanApplicationBtn = new GUI.GlassButton("<html><center>Loan<br>Application</center></html>");
        ui.setPositionRelative(TransferBtn, LoanApplicationBtn, 200,0,100,100);
        this.add(LoanApplicationBtn);

        //Currency Exchange Button
        GUI.GlassButton CurrencyExchangeBtn = new GUI.GlassButton("<html><center>Currency<br>Exchange</center></html>");
        ui.setPositionRelative(LoanApplicationBtn, CurrencyExchangeBtn, 200,0,100,100);
        this.add(CurrencyExchangeBtn);

        //Profile Button
        GUI.GlassButton ProfileBtn = new GUI.GlassButton("Profile");
        ui.setPositionRelative(CurrencyExchangeBtn, ProfileBtn, 200,0,100,100);
        this.add(ProfileBtn);











    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}
