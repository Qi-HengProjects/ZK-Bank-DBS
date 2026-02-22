package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //LoginPage login = new LoginPage();
        //LoanApplicationWindow loan = new LoanApplicationWindow();

        // ignore starting here, just a test
        System.out.println("=== Starting Digital Bank System Test ===\n");

        // 1. Initialize the File Manager
        DataManager dataManager = new DataManager();

        // 2. Try to load existing users from the hard drive
        List<User> bankDatabase = dataManager.loadUsers();
        System.out.println("✅ Successfully loaded " + bankDatabase.size() + " users from database.");

        // 3. If the database is empty (first time running), create dummy data
        if (bankDatabase.isEmpty()) {
            System.out.println("\n⚠️ Database is empty. Generating test data...");

            // Create a brand new User
            User testUser = new User("990101-14-5555", "test_user", "password123");

            // Create two Accounts for this user
            Account savings = new Account("ACC-001", "SAVINGS", 1500.00);
            Account investment = new Account("ACC-002", "INVESTMENT", 5500.50);

            // Add accounts to the user's wallet
            testUser.addAccount(savings);
            testUser.addAccount(investment);

            // Add the user to our main RAM database
            bankDatabase.add(testUser);

            // Save the RAM database to the JSON file
            dataManager.saveUsers(bankDatabase);
            System.out.println("✅ Test data created and saved to bank_data.json!");
        }

        // 4. Print out everything currently in the system to verify it works
        System.out.println("\n=== Current Bank Records ===");
        for (User u : bankDatabase) {
            System.out.println("Username: " + u.getUsername());

            // This tests your getTotalBalance() method!
            System.out.println("Total Balance: RM " + u.getTotalBalance());

            System.out.println("Accounts:");
            // Loop through the inner list to print accounts
            for (Account acc : u.getAccounts()) {
                System.out.println("  -> " + acc.toString());
            }
            System.out.println("----------------------------");
        }

        System.out.println("\n=== Test Complete ===");
    }
}