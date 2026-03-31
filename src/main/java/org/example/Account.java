package org.example;
import java.util.Date;
// remember to put abstract later
public abstract class Account {
    private String accountNumber;
    private String type;
    private double balance;
    private String dateCreated;

    public Account(String accountNumber, String type, double balance, String dateCreated){
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    public void addInterest() {

    }

    public boolean withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a value > 0");
            return false;
        } else {
            return true;
        }
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a valid amount > 0");
            return false;
        } else {
            return true;
        }
    }

    // getter accountNumber
    public String getAccountNumber() {
        return this.accountNumber;
    }

    // getter type
    public String getType() {
        return this.type;
    }

    // getter balance
    public double getBalance() {
        return this.balance;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    // setter balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return type + " (" + accountNumber + "): RM " + balance;
    }
}
