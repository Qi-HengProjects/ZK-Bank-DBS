package org.example;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;


public class TopBlueBar extends JPanel {
    private HeaderButton Home;
    private HeaderButton Report;
    private HeaderButton LoanApp;
    private HeaderButton Contact;

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
        Home = new HeaderButton("Home");
        Home.setBounds(0, 150, 100, 40);
        Home.setEnabled(Main.toggle_status);
        Home.addActionListener(e -> {
            System.out.println("home");
        });
        this.add(Home);


        // Report button
        Report = new HeaderButton("Report");
        Report.setBounds(0, 250, 100, 40);
        Report.setEnabled(Main.toggle_status);
        Report.addActionListener(e -> {
            System.out.println("report");
        });
        this.add(Report);


        // Loan Application button
        LoanApp = new HeaderButton("<html><center>Apply<br>Loan</center></html>");
        LoanApp.setBounds(0, 350, 100, 80);
        LoanApp.setEnabled(Main.toggle_status);
        LoanApp.addActionListener(e -> {
            System.out.println("LA");
            new LoanApplicationWindow();
        });
        this.add(LoanApp);


        // Contact button
        Contact = new HeaderButton("Contact");
        Contact.setBounds(0, 490 , 110, 40);
        Contact.setEnabled(Main.toggle_status);
        Contact.addActionListener(e -> {
            System.out.println("C");
        });
        this.add(Contact);


        //Making the frame visible and positioning


    }


    private static class HeaderButton extends JButton {
        private final String rawText;
        private final boolean isHtml;

        private static final Color ENABLED_COLOR  = Color.WHITE;
        private static final Color DISABLED_COLOR = new Color(150, 160, 175);

        public HeaderButton(String text) {
            super(text);
            this.isHtml = text.startsWith("<html>");
            // Strip html tags to store just the core content
            this.rawText = text;

            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setForeground(ENABLED_COLOR);
            this.setBackground(new Color(0, 51, 102));
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.setFont(new Font("Arial", Font.BOLD, 18));
        }



        @Override
        public void setEnabled(boolean enabled) {
            super.setEnabled(enabled);
            String hex = enabled ? "#FFFFFF" : "#969FB0";
            if (isHtml) {
                // Wrap the inner content with a font color tag
                String inner = rawText.replace("<html>", "").replace("</html>", "");
                setText("<html><font color='" + hex + "'>" + inner + "</font></html>");
            } else {
                setForeground(enabled ? ENABLED_COLOR : DISABLED_COLOR);
            }
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


        Home.setEnabled(Main.toggle_status);
        Report.setEnabled(Main.toggle_status);
        LoanApp.setEnabled(Main.toggle_status);
        Contact.setEnabled(Main.toggle_status);

        this.revalidate();
        this.repaint();

    }
}






