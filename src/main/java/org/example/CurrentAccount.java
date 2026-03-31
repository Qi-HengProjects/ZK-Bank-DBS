package org.example;
import java.util.Date;

public class CurrentAccount extends Account{
    private int transactionCount;
    private final double transactionFee = 0.5;

    public CurrentAccount(String accountNumber, double balance, String dateCreated) {
        super(accountNumber, "current", balance, dateCreated);
    }

    @Override
    public boolean withdraw(double amount) {
        boolean status = false;
        if (super.withdraw(amount)){
            if (getBalance() < (transactionFee + amount)) {
                System.out.println("Insufficient balance");
            } else if (getBalance() >= (transactionFee + amount)) {
                setBalance(getBalance() - (transactionFee + amount));
                System.out.println("Money transfered: " + amount +
                        "Transaction Fee: " +  getTransactionFee());
                status = true;
            }
        }
        increaseTransactionCount(status);
        return status;
    }

    @Override
    public boolean deposit(double amount) {
        boolean status = false;
        if (super.deposit(amount)) {
            setBalance(getBalance() + amount);
            System.out.println(amount + " Money has been added");
            status = true;
        }
        increaseTransactionCount(status);
        return status;
    }

    public int getTransactionCount() {
        return this.transactionCount;
    }

    public double getTransactionFee() {
        return this.transactionFee;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public void increaseTransactionCount(boolean status) {
        if (status) {
            this.transactionCount++;
        }
    }
}