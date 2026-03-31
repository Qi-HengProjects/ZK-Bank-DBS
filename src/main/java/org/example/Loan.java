package org.example;

public class Loan {
    private String loanID;
    private double loanAmount;
    private double remainingAmount;
    private String loanStatus;
    private double interestRate;
    private double monthlyInstallment;
    private String loanPeriod;

    public Loan(String loanID,double loanAmount, String loanStatus, double interestRate, double monthlyInstallment, String endDate) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.remainingAmount = loanAmount;
        this.loanStatus = loanStatus;
        this.interestRate = interestRate;
        this.monthlyInstallment = monthlyInstallment;
        this.loanPeriod = endDate;
    }

    public String getLoanID() {
        return this.loanID;
    }

    public double getLoanAmount() {
        return this.loanAmount;
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

    public String getLoanPeriod() {
        return this.loanPeriod;
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

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
}

