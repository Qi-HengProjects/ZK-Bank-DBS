package org.example;

public class CurrentAccount extends Account{
    private int transactionCount;
    private final double transactionFee = 0.5;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, "current", balance);
        this.transactionCount = 0;
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

    public void increaseTransactionCount() {
        this.transactionCount++;
    }

}
