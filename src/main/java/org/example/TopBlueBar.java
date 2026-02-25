package org.example;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;


public class TopBlueBar extends JPanel {
    private HeaderButton Home;
    private HeaderButton Personal;
    //private HeaderButton LoanApp;
    private HeaderButton Contact;

    public TopBlueBar() {
        //Var for the name of the window, call it from other classes.

        this.setBackground(new Color(0, 51, 102));
        this.setPreferredSize(new Dimension(130, 800));
        this.setLayout(null);



        //Top Blue Header
        ImageIcon img = new ImageIcon("logo_Icon.jpg");
        Image logo_icon = img.getImage();
        Image scaled_img = logo_icon.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
        ImageIcon scaled_logo = new ImageIcon(scaled_img);

        JLabel logo = new JLabel(scaled_logo);
        logo.setBounds(0, 10, 130, 100);
        this.add(logo);

        // Home button
        Home = new HeaderButton("Home");
        Home.setBounds(0, 150, 130, 40);
        Home.addActionListener(e -> {
            System.out.println("home");
        });
        this.add(Home);


        // Personal button
        Personal = new HeaderButton("Personal");
        Personal.setBounds(0, 250, 130, 40);
        Personal.addActionListener(e -> {


            if (Main.toggle_status == false) {

                // Show the pop-up warning
                JOptionPane.showMessageDialog(
                        this, // or null
                        "Access Denied. Please log in first.",
                        "Access Denied",
                        JOptionPane.WARNING_MESSAGE
                );

            } else {
                // They are logged in! Let them through.
                System.out.println("in");
                new LoanApplicationPanel();


            }
        });

        this.add(Personal);


        // Loan Application button
        //LoanApp = new HeaderButton("Loan");
        //LoanApp.setBounds(0, 350, 100, 80);
        //LoanApp.setEnabled(Main.toggle_status);
        //LoanApp.addActionListener(e -> {
        //    System.out.println("LA");
        //    new LoanApplicationPanel();
        //});
        //this.add(LoanApp);


        // Contact button
        Contact = new HeaderButton("Contact");
        Contact.setBounds(0, 350 , 130, 40);
        Contact.addActionListener(e -> {
            System.out.println("C");
        });
        this.add(Contact);

    }


    private static class HeaderButton extends JButton {
        public HeaderButton(String text) {
            super(text);

            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setBackground(new Color(0, 51, 102));
            this.setForeground(Color.WHITE);
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setFont(new Font("Arial", Font.BOLD, 18));

        }
    }
    public void LockLogic(){
        //setEnable toggle logic core
        if ("Signed Out".equals(Main.account_status)){
            Main.toggle_status = false;
        } else if ("Signed In".equals(Main.account_status)){
            Main.toggle_status = true;

        } else if ("Frozen".equals(Main.account_status)) {
            Main.toggle_status = false;
        }

        Personal.setEnabled(Main.toggle_status);
        this.revalidate();
        this.repaint();

    }
    public class SignUpFirst extends JOptionPane{
        public SignUpFirst(){
            SignUpFirst.showMessageDialog(
                    null,
                    "Please log in first.",
                    "Access Denied",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}






