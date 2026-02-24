package org.example;
import java.util.ArrayList;
import java.util.List;

public class User {
    //Encapsulation so other class cannot access directly
    private String userID; // IC number
    private String username;
    private String password;

    private List<Account> accounts;

    public User(String userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public double getTotalBalance() {
        double total = 0.0;

        for (Account acc : this.accounts) {
            total = total + acc.getBalance();
        }

        return total;
    }

    // Getter
    public String getUsername() {
        return this.username;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public String toString() {
        return "User: " + username + " | Total Accounts: " + accounts.size();
    }
}
