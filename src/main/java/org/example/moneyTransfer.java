package org.example;

public class moneyTransfer {
    public String generateUserID() {
        String text = "U001";
        String[] id = text.substring(0,1).split("");
        int idNum = Integer.parseInt(id[1].trim());
        idNum = idNum + 1;
        return "U" + String.valueOf(idNum);
    }
}
