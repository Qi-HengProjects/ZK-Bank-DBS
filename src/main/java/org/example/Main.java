package org.example;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {
    public static String account_status = "Signed Out";
    public static Boolean toggle_status = false;

    private static CardLayout cardLayout = new CardLayout();
    private static JPanel mainPanel = new JPanel(cardLayout);

    public Main() {
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Register all your pages here
        mainPanel.add(new LoginPanel(), "Login");
        mainPanel.add(new LoanApplicationPanel(), "LoanApp");
        // mainPanel.add(new HomePanel(), "Home");
        // add more panels as you build them...

        TopBlueBar bar = new TopBlueBar();
        this.add(bar, BorderLayout.WEST);
        this.add(mainPanel, BorderLayout.CENTER);

        showPage("Login"); // start on login page
        this.setVisible(true);
    }

    // Call this from anywhere to navigate
    public static void showPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    public static void main(String[] args) {
        new Main();
    }
}


