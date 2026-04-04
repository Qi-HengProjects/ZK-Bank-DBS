package org.example;

public class Transaction {
    private double transactionAmount;
    private String transactionID;
    private String transactionStatus;
    private String transactionDate;

    public Transaction(double transactionAmount, String transactionID, String transactionStatus, String transactionDate) {
        this.transactionAmount = transactionAmount;
        this.transactionID = transactionID;
        this.transactionStatus = transactionStatus;
        this.transactionDate = transactionDate;
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

    public void setReceiverType(String receiverType) {
        this.transactionStatus = transactionStatus;
    }

    /*public String generateUserID() {
       Random random = new Random();
       random.nextLong((999999999 - 100000001) + 100000000);
       String newTransferID = "TXN-" + random.toString();
       return random.toString();
    }*/
}
