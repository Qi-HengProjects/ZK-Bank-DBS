package org.example;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {
    // Create the one and only data manager

    public static DataManager dataManager = new DataManager("bank_data.json");

    public static AccountStatus account_status = AccountStatus.SignedOut;
    public static Boolean toggle_status = false;
    public static Boolean Theme_status = false;
    public static TopBlueBar bar = new TopBlueBar();

    private static final CardLayout cardLayout = new CardLayout();
    public static final JPanel mainPanel = new JPanel(cardLayout);
    public static String currentPage = "Login";

    public static String currentSession;
    public static Object currentObject;

    public enum AccountStatus {
        SignedIn, SignedOut, Freeze
    }

    public Main() {
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(bar, BorderLayout.WEST);
        this.add(mainPanel, BorderLayout.CENTER);

        showPage("Login"); // start on login page
        this.setVisible(true);
    }

    // Call this from anywhere to navigate
    public static void showPage(String pageName) {
        currentPage = pageName;

        // remove old panel and add fresh one each time
        mainPanel.removeAll();

        switch (pageName) {
            case "Login" -> mainPanel.add(new LoginPanel(), "Login");
            case "LoanApp" -> mainPanel.add(new LoanApplicationPanel(), "LoanApp");
            case "Home" -> mainPanel.add(new Home(), "Home");
            case "Contact" -> mainPanel.add(new Contact(), "Contact");
            case "Profile" -> mainPanel.add(new Profile(), "Profile");

        }

        cardLayout.show(mainPanel, pageName);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        new Main();
    }
}


