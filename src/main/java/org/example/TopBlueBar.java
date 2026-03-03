package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class TopBlueBar extends JPanel {
    private final HeaderButton Home;
    private final HeaderButton Personal;
    //private HeaderButton LoanApp;
    private final HeaderButton Contact;
    private final HeaderButton Theme;
    GUI ui = new GUI();

    public TopBlueBar() {
        //Var for the name of the window, call it from other classes.

        this.setBackground(Color.decode(GUI.DarkBlueColorCode));
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


            if (!Main.toggle_status) {

                // Show the pop-up warning
                JOptionPane.showMessageDialog(this, // or null
                        "Access Denied. Please log in first.", "Access Denied", JOptionPane.WARNING_MESSAGE);

            } else {
                // They are logged in! Let them through.
                System.out.println("in");
                new LoanApplicationPanel();


            }
        });

        this.add(Personal);

        // Contact button
        Contact = new HeaderButton("Contact");
        Contact.setBounds(0, 350, 130, 40);
        Contact.addActionListener(e -> {
            System.out.println("C");
        });
        this.add(Contact);

        // Theme Changer button
        Theme = new HeaderButton(GUI.ThemeButton);
        Theme.setFont(new Font("Arial", Font.PLAIN, 14));
        Theme.setBounds(0, 600, 150, 40);
        Theme.addActionListener(e -> {
            Main.Theme_status = true;
        });
        this.add(Theme);




    }

    public void LockLogic() {
        //setEnable toggle logic core
        if (Objects.equals("Signed Out", Main.account_status)) {
            Main.toggle_status = false;
        } else if (Objects.equals("Signed In", Main.account_status)) {
            Main.toggle_status = true;

        } else if (Objects.equals("Frozen", Main.account_status)) {
            Main.toggle_status = false;
        }

        Personal.setEnabled(Main.toggle_status);
        this.revalidate();
        this.repaint();

    }

    private static class HeaderButton extends JButton {
        public HeaderButton(String text) {
            super(text);

            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setBackground(Color.decode(GUI.DarkBlueColorCode));
            this.setForeground(Color.decode(GUI.WhiteColorCode));
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setFont(new Font("Arial", Font.BOLD, 18));



        }
    }

    public class SignUpFirst extends JOptionPane {
        public SignUpFirst() {
            SignUpFirst.showMessageDialog(null, "Please log in first.", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }

}






