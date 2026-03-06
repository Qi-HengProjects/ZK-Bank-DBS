package org.example;

import javax.swing.*;
import java.awt.*;

public class Contact extends JPanel{
    Image chinabackground4 = new ImageIcon("ChinaBackground4.jpg").getImage();
    GUI ui = new GUI();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground4, 0, 0, getWidth(), getHeight(), this);
    }
    public Contact(){
        this.setLayout(null);


        //Contact Us Label (center)
        JLabel ContactUs = new JLabel("Contact Us");
        ContactUs.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics fmPlain = ContactUs.getFontMetrics(ContactUs.getFont());
        int contactUsWidth = fmPlain.stringWidth("Contact Us");
        ui.setPosition(ContactUs, 300, 100,contactUsWidth +10, 100);
        this.add(ContactUs);

        //Glass Panel
        GUI.GlassPanel ContactBlackBox = new GUI.GlassPanel();
        ContactBlackBox.setSize(600, 400);
        ContactBlackBox.setBackground(Color.decode(GUI.DarkGreyColorCode));
        ui.setPosition(ContactBlackBox, 125, 200, 600, 400);
        this.add(ContactBlackBox);

        //Banking enquiries Label
        JLabel BankingEnquiries = new JLabel("Banking Enquiries?");
        BankingEnquiries.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 25));
        BankingEnquiries.setForeground(Color.decode("#000000"));
        ui.setPosition(BankingEnquiries, 20,10,300,50);
        ContactBlackBox.add(BankingEnquiries);

        //Contact Phone Number
        JLabel ContactPhoneNumber = new JLabel("Tel No.   :  +6011-10081475");
        ContactPhoneNumber.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 20));
        ContactPhoneNumber.setForeground(Color.decode("#000000"));
        ui.setPositionRelative(BankingEnquiries, ContactPhoneNumber, 20, 70, 400,30);
        ContactBlackBox.add(ContactPhoneNumber);

        //Email Address
        JLabel EmailAddress = new JLabel("Email     :   orangeteacher@gmail.com");
        EmailAddress.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 20));
        EmailAddress.setForeground(Color.decode("#000000"));
        ui.setPositionRelative(ContactPhoneNumber, EmailAddress, 0, 40, 400,30);
        ContactBlackBox.add(EmailAddress);

        //Email Address
        JLabel BranchAddress = new JLabel("<html><table><tr><td valign='top'>Address :&nbsp;</td><td>Ground Floor,<br>Bangunan Tan Sri Khaw Kai Boh (Block A),<br>Jalan Genting Kelang, Setapak,<br>53300 Kuala Lumpur,<br>Federal Territory of Kuala Lumpur,<br>Malaysia</td></tr></table></html>");
        BranchAddress.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 20));
        BranchAddress.setForeground(Color.decode("#000000"));
        ui.setPositionRelative(EmailAddress, BranchAddress, -5, 0, 550,220);
        ContactBlackBox.add(BranchAddress);










    }

}
