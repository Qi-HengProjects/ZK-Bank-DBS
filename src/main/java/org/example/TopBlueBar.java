package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class TopBlueBar extends JPanel {
    private final HeaderButton Home;

    //private HeaderButton LoanApp;
    private final HeaderButton Contact;
    private final HeaderButton TempLbtn;
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
        Home.setBorderPainted(false);
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
        Contact.setBorderPainted(false);
        Contact.addActionListener(e -> {
            Main.showPage("Contact");
            //Main.showPage("accountRequest");
        });
        this.add(Contact);

        TempLbtn = new HeaderButton("Login/SignUp");
        TempLbtn.setFont(new Font("Arial", Font.PLAIN, 14));
        TempLbtn.setBounds(0, 600, 120, 40);
        TempLbtn.setBorderPainted(false);
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


    public static class sideWhiteBar extends JPanel {
        // 1. Define the List and Borders locally for this panel
        private final List<HeaderButton> navButtons = new ArrayList<>();
        private final javax.swing.border.Border underline = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode(GUI.WhiteColorCode));
        private final javax.swing.border.Border noUnderline = BorderFactory.createEmptyBorder(0, 0, 3, 0);

        public sideWhiteBar() {
            this.setPreferredSize(new Dimension(1000, 50));
            this.setBackground(Color.decode(GUI.DarkBlueColorCode));
            this.setLayout(null); // Ensure layout is null for setBounds to work

            // 2. Create 'New Account Request' Button
            HeaderButton accApplySection = new HeaderButton("New Account Request");
            accApplySection.setBounds(50, 15, 200, 25);
            setupNavButton(accApplySection);
            accApplySection.addActionListener( e -> {
                Main.showPage("accountRequest");
            });
            this.add(accApplySection);

            // 3. Create 'New Loan Request' Button
            HeaderButton loanApplySection = new HeaderButton("New Loan Request");
            loanApplySection.setBounds(300, 15, 200, 25);
            setupNavButton(loanApplySection);
            loanApplySection.addActionListener( e -> {
                Main.showPage("loanRequest");
            });
            this.add(loanApplySection);

            // Start with the first one selected
            setActiveTab(accApplySection);
        }

        // Helper to add to list and set listener
        private void setupNavButton(HeaderButton btn) {
            navButtons.add(btn);
            btn.addActionListener(e -> setActiveTab(btn));
        }

        // The logic to switch the underline
        private void setActiveTab(HeaderButton selectedBtn) {
            for (HeaderButton btn : navButtons) {
                if (btn == selectedBtn) {
                    btn.setBorder(underline);
                    btn.setForeground(Color.WHITE); // Active color
                } else {
                    btn.setBorder(noUnderline);
                    btn.setForeground(Color.GRAY);  // Inactive color
                }
            }
        }
    }
}






