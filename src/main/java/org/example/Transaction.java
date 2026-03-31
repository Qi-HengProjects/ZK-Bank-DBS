package org.example;

public class Transaction {
    private double transactionAmount;
    private String transactionID;
    private String receiverType;
    private String transactionDate;

    public Transaction(double transactionAmount, String transactionId, String receiverType, String transactionDate) {
        this.transactionAmount = transactionAmount;
        this.transactionID = transactionId;
        this.receiverType = receiverType;
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public String getReceiverType() {
        return this.receiverType;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    /*public String generateUserID() {
       Random random = new Random();
       random.nextLong((999999999 - 100000001) + 100000000);
       String newTransferID = "TXN-" + random.toString();
       return random.toString();
    }*/
}
