package org.example;

import javax.swing.*;
import java.awt.*;


public class TopBlueBar extends JPanel {
    public TopBlueBar() {
        //Var for the name of the window, call it from other classes.

        this.setBackground(new Color(0, 51, 102));
        this.setPreferredSize(new Dimension(120, 800));
        this.setLayout(null);

        //Top Blue Header
        ImageIcon img = new ImageIcon("logo_Icon.jpg");
        Image logo_icon = img.getImage();
        Image scaled_img = logo_icon.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
        ImageIcon scaled_logo = new ImageIcon(scaled_img);

        JLabel logo = new JLabel(scaled_logo);
        logo.setForeground(Color.YELLOW);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setBounds(0, 10, 120, 100);
        this.add(logo);

        // Home button
        HeaderButton Home = new HeaderButton("Home");
        Home.setPosition(0, 150, 100, 40);
        Home.addActionListener(e -> {
            System.out.println("home");
        });
        this.add(Home);

        // Report button
        HeaderButton Report = new HeaderButton("Report");
        Report.setPosition(0, 250, 100, 40);
        Report.addActionListener(e -> {
            System.out.println("report");
        });
        this.add(Report);

        // Loan Application button
        HeaderButton LoanApp = new HeaderButton("<html><center>Apply<br>Loan</center></html>");
        LoanApp.setPosition(0, 350, 100, 80);
        LoanApp.addActionListener(e -> {
            System.out.println("LA");
            new LoanApplicationWindow();
        });
        this.add(LoanApp);

        // Contact button
        HeaderButton Contact = new HeaderButton("Contact");
        Contact.setPosition(0, 490 , 110, 40);
        Contact.addActionListener(e -> {
            System.out.println("C");
        });
        this.add(Contact);

        //Making the frame visible and positioning


    }


    private static class HeaderButton extends JButton {
        public HeaderButton(String text) {
            super(text);

            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setForeground(Color.WHITE);
            this.setBackground(new Color(0, 51, 102));
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setFont(new Font("Arial", Font.BOLD, 18));
        }

        public void setPosition(int x, int y, int width, int height) {
            this.setBounds(x, y, width, height);
        }
    }
}



class main{
    public static void main(String[] args) {

        new TopBlueBar();
    }
}



