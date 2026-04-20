package org.example;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String dateCreated) {
        super(accountNumber, "Savings", balance, dateCreated);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < 20.00) {
            System.out.println("Transaction Denied: RM 20.00 minimum balance required.");
            return false;
        }

        if (super.withdraw(amount)) {
            setBalance(getBalance() - amount);
            addInterest();
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        if (super.deposit(amount)) {
            setBalance(getBalance() + amount);
            addInterest();
            return true;
        }
        return false;
    }

    @Override
    public void addInterest() {
        double currentBalance = getBalance();
        if (currentBalance < 1000) {
            this.interestRate = 0.01; // 1%
        } else if (currentBalance < 20000) {
            this.interestRate = 0.02; // 2%
        } else {
            this.interestRate = 0.04; // 4%
        }
    }
}
