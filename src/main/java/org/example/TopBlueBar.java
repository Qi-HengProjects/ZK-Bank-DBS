package org.example;

import javax.swing.*;
import java.awt.*;


public class TopBlueBar extends JPanel {
    private final HeaderButton Home;

    //private HeaderButton LoanApp;
    private final HeaderButton Contact;
    private final HeaderButton TempLbtn;
    private final HeaderButton Staff;
    private final JButton dropdownBtn = new JButton("Personal ▼");

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
            if (!Main.toggle_status) {
                // Show the pop-up warning
                JOptionPane.showMessageDialog(this, // or null
                        "Access Denied. Please log in first.", "Access Denied", JOptionPane.WARNING_MESSAGE);

            } else {
                Main.showPage("Home");
            }

        });
        this.add(Home);


        // Personal button (PopupMenu)
        JPopupMenu dropdown = new JPopupMenu("Personal");

        JMenuItem TransferOption = new JMenuItem("Transfer");
        JMenuItem LoanApplicationOption = new JMenuItem("Loan Application");
        JMenuItem CurrencyExchangeOption = new JMenuItem("Currency Exchange");

        dropdown.add(TransferOption);
        dropdown.add(LoanApplicationOption);
        dropdown.add(CurrencyExchangeOption);

        dropdownBtn.addActionListener(e -> {
            if (!Main.toggle_status) {

                // Show the pop-up warning
                JOptionPane.showMessageDialog(this, // or null
                        "Access Denied. Please log in first.", "Access Denied", JOptionPane.WARNING_MESSAGE);

            } else {
                dropdown.show(dropdownBtn, 0, dropdownBtn.getHeight());
            }
        });

        TransferOption.addActionListener(e -> {
            System.out.println("Transfer Option clicked");
            //Main.showPage("Transfer");
        });

        LoanApplicationOption.addActionListener(e -> {
            System.out.println("Loan Application clicked");
            Main.showPage("LoanApp");
        });

        CurrencyExchangeOption.addActionListener(e -> {
            System.out.println("Currency Exchange");
            //Main.showPage("SomePage");
        });

        dropdownBtn.setBorderPainted(false);
        dropdownBtn.setContentAreaFilled(false);
        dropdownBtn.setFocusPainted(false);
        dropdownBtn.setForeground(Color.decode(GUI.WhiteColorCode));
        dropdownBtn.setFont(new Font("Arial", Font.BOLD, 18));
        dropdownBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dropdownBtn.setBounds(0, 250, 140, 40);

        this.add(dropdownBtn);

        // Contact button
        Contact = new HeaderButton("Contact");
        Contact.setBounds(0, 350, 130, 40);
        Contact.addActionListener(e -> {
            System.out.println("C");
            Main.showPage("Contact");
        });
        this.add(Contact);

        //Staff button
        Staff = new HeaderButton("Staff");
        Staff.setBounds(0, 450, 130, 40);
        Staff.addActionListener(e -> {
            Main.showPage("Admin");
        });
        this.add(Staff);

        TempLbtn = new HeaderButton("Login/SignUp");
        TempLbtn.setFont(new Font("Arial", Font.PLAIN, 14));
        TempLbtn.setBounds(0, 600, 120, 40);
        TempLbtn.addActionListener(e -> {
            Main.showPage("Login");
        });
        if (Main.account_status == Main.AccountStatus.SignedIn) {
            this.remove(TempLbtn);
        } else {
            this.add(TempLbtn);
        }


    }

    public void LockLogic() {
        //setEnable toggle logic core
        if (Main.account_status == Main.AccountStatus.SignedOut) {
            Main.toggle_status = false;
        } else if (Main.account_status == Main.AccountStatus.SignedIn) {
            Main.toggle_status = true;

        } else if (Main.account_status == Main.AccountStatus.Freeze) {
            Main.toggle_status = false;
        }

        if (Main.account_status == Main.AccountStatus.SignedIn) {
            this.remove(TempLbtn);
        } else {
            if (!isAncestorOf(TempLbtn)) { // only add if not already added
                this.add(TempLbtn);
            }
        }

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






