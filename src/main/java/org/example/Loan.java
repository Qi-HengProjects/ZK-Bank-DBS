package org.example;

public class Loan {
    private String loanID;
    private double loanAmount;
    private double paymentAmount;
    private double remainingAmount;
    private String loanStatus;
    private double interestRate;
    private double monthlyInstallment;
    private double loanPeriod;
    private String startingDate;

    public Loan(String loanID, double loanAmount, double paymentAmount, String loanStatus, double interestRate, double monthlyInstallment, double loanPeriod, String startingDate) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.loanStatus = loanStatus;
        this.interestRate = interestRate;
        this.monthlyInstallment = monthlyInstallment;
        this.loanPeriod = loanPeriod;
        this.startingDate = startingDate;
    }

    // Updated Loan.java logic
    public double calculatePaymentAmount(double loanAmount, double loanPeriod) {
        // Correct Formula: Total = Principal + (Principal * Rate * Years)
        double totalInterest = loanAmount * loanInterest(loanAmount) * loanPeriod;
        this.paymentAmount = loanAmount + totalInterest;
        return this.paymentAmount;
    }

    public double loanInterest(double loanAmount) {
        // Tiered interest based on amount
        if (loanAmount < 10000) {
            this.interestRate = 0.035; // 3.5%
        } else if (loanAmount < 50000) {
            this.interestRate = 0.05;  // 5%
        } else {
            this.interestRate = 0.075; // 7.5%
        }
        return this.interestRate;
    }

    public String getLoanID() {
        return this.loanID;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public double getPaymentAmount() {
        return  this.paymentAmount;
    }

    public double getRemainingAmount() {
        return this.remainingAmount;
    }

    public String getLoanStatus() {
        return this.loanStatus;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public double getMonthlyInstallment() {
        return this.monthlyInstallment;
    }

    public double getLoanPeriod() {
        return this.loanPeriod;
    }

    public String getStartingDate() {
        return this.startingDate;
    }


    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonthlyInstallment(double monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public void setLoanPeriod(double loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
}

