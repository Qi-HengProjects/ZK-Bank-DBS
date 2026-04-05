package org.example;

public class Transaction {
    private double transactionAmount;
    private String transactionID;
    private String transactionStatus;
    private String transactionDate;
    private String transactionDetails;

    public Transaction(double transactionAmount, String transactionID, String transactionStatus, String transactionDate, String transactionDetails) {
        this.transactionAmount = transactionAmount;
        this.transactionID = transactionID;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
        this.transactionDetails = transactionDetails;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public String getReceiverType() {
        return this.transactionStatus;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public String getTransactionDetails() {
        return this.transactionDetails;
    }

    public void setReceiverType(String receiverType) {
        this.transactionStatus = transactionStatus;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
