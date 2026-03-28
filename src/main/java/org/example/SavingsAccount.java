package org.example;

public class SavingsAccount extends Account {
    private  static double interestRate = 0.04;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, "Savings", balance);
    }

    @Override
    public void addInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest added to " + getAccountNumber());
    }
}
