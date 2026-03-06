package org.example;
import java.awt.*;
import java.util.Objects;
import javax.naming.Name;
import javax.swing.*;

public class Home extends JPanel {
    GUI ui = new GUI();

    Image chinabackground3 = new ImageIcon("ChinaBackground3.jpg").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground3, 0, 0, getWidth(), getHeight(), this);
    }

    public Home(){
        this.setLayout(new BorderLayout());
        this.setLayout(null);

        //Hello Label
        JLabel HelloLabel = new JLabel("Hello ");
        HelloLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        HelloLabel.setForeground(Color.decode(GUI.BlackColorCode));
        this.add(HelloLabel);

        //Name Label
        String NameOfUser = LoginPanel.UsernameValue;//write name from json file stop at first spacebar. Default 'User' when not logged in. can use the enum to check account status
        JLabel NameLabel = new JLabel(NameOfUser);
        NameLabel.setFont(new Font("Arial", Font.ITALIC, 50));
        NameLabel.setForeground(Color.decode(GUI.BlackColorCode));


        //Name position 的算法
        FontMetrics fmPlain = HelloLabel.getFontMetrics(HelloLabel.getFont());
        FontMetrics fmItalic = NameLabel.getFontMetrics(NameLabel.getFont());
        int helloWidth = fmPlain.stringWidth("Hello ");
        if (LoginPanel.UsernameValue != null) {
            int nameWidth = fmItalic.stringWidth(LoginPanel.UsernameValue);
            int totalWidth = helloWidth + nameWidth;
            int startX = 425 - (totalWidth / 2); // center around x=385
            HelloLabel.setBounds(startX, 100, helloWidth + 10, 100);
            NameLabel.setBounds(startX + helloWidth, 100, nameWidth + 20, 100);
        }

        this.add(NameLabel);





        //Transfer Button
        GUI.GlassButton TransferBtn = new GUI.GlassButton("Transfer");
        ui.setPosition(TransferBtn, 70,300,120,120);
        this.add(TransferBtn);

        //Loan Application Button
        GUI.GlassButton LoanApplicationBtn = new GUI.GlassButton("<html><center>Loan<br>Application</center></html>");
        ui.setPositionRelative(TransferBtn, LoanApplicationBtn, 200,0,120,120);
        LoanApplicationBtn.addActionListener(e -> {
            Main.showPage("LoanApp");
        });

        this.add(LoanApplicationBtn);

        //Currency Exchange Button
        GUI.GlassButton CurrencyExchangeBtn = new GUI.GlassButton("<html><center>Currency<br>Exchange</center></html>");
        ui.setPositionRelative(LoanApplicationBtn, CurrencyExchangeBtn, 200,0,120,120);
        this.add(CurrencyExchangeBtn);

        //Profile Button
        GUI.GlassButton ProfileBtn = new GUI.GlassButton("Profile");
        ui.setPositionRelative(CurrencyExchangeBtn, ProfileBtn, 200,0,120,120);
        ProfileBtn.addActionListener(e ->{
            Main.showPage("Profile");
        });
        this.add(ProfileBtn);


    }
    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        // re-apply whatever colors that panel uses
        this.repaint();
    }
}
