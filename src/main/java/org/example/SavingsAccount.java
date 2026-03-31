package org.example;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String dateCreated) {
        super(accountNumber, "Savings", balance, dateCreated);
    }

    @Override
    public boolean withdraw(double amount) {
        boolean status = false;
        if (super.withdraw(amount)) {
            if (amount + 20 > getBalance()){
                System.out.println("Insufficient savings, minimum of RM 20.00 needed to keep the account active");
            } else {
                setBalance(getBalance() - amount);
                System.out.println("Lastest balance after the transfer: " + getBalance());
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean deposit(double amount) {
        boolean status = false;

        if (super.deposit(amount)) {
            setBalance(getBalance() + amount);
            System.out.println(amount + " Money has been added");
            status = true;

            double currentBalance = getBalance();
            if (currentBalance < 1000) {
                this.interestRate =  0.01;
            } else if (currentBalance < 10000) {
                interestRate = 0.02;
                this.interestRate =  0.02;
            } else if (currentBalance >= 20000) {
                this.interestRate = 0.04;
            }
        }
        return status;
    }

    @Override
    public void addInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest added to " + getAccountNumber());
    }
}
