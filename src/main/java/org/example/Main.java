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
    public static TopBlueBar.sideWhiteBar whiteBar =  new TopBlueBar.sideWhiteBar();

    private static final CardLayout cardLayout = new CardLayout();
    public static final JPanel mainPanel = new JPanel(cardLayout);
    public static String currentPage = "Login";

    public static String currentSession;

    public enum AccountStatus {
        SignedIn, SignedOut, Freeze
    }

    public static void showPage(String pageName) {
        currentPage = pageName;

        // remove old panel and add fresh one each time
        mainPanel.removeAll();

        if (currentPage.equals("accountRequest") || currentPage.equals("loanRequest")){
            bar.setVisible(false);
            whiteBar.setVisible(true);

        } else {
            bar.setVisible(true);
            whiteBar.setVisible(false);
        }

        switch (pageName) {
            case "Login" -> mainPanel.add(new LoginPanel(), "Login");
            case "LoanApp" -> mainPanel.add(new LoanApplicationPanel(), "LoanApp");
            case "Home" -> mainPanel.add(new Home(), "Home");
            case "Contact" -> mainPanel.add(new Contact(), "Contact");
            case "Profile" -> mainPanel.add(new Profile(), "Profile");
            case "Transfer" -> mainPanel.add(new TransferPage(), "Transfer");
            case "accountRequest" -> mainPanel.add(new Admin.newAccountRequest(), "accountRequest");
            case "loanRequest" -> mainPanel.add(new Admin.newLoanRequest(), "loanRequest");

        }

        cardLayout.show(mainPanel, pageName);
        if (mainPanel.getParent() != null) {
            mainPanel.getParent().revalidate();
            mainPanel.getParent().repaint();
        }
    }

    public Main() {
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(bar, BorderLayout.WEST);
        this.add(whiteBar, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);

        showPage("Login");
        this.setTitle("Zha Kai Bank");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}


