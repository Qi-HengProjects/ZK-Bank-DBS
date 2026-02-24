package org.example;

public class Account {
    private String accountNumber;
    private String type;
    private double balance;

    public Account(String accountNumber, String type, double balance){
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
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

    // setter balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return type + " (" + accountNumber + "): RM " + balance;
    }
}
