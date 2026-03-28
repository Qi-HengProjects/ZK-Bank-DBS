package org.example;
import java.util.ArrayList;
import java.util.List;

public class User {
    //Encapsulation so other class cannot access directly
    private String name;
    private String IC_No;
    private String birthday;
    private String gender;
    private String nationality;
    private String race;
    private String religion;
    private String telNo;
    private String address;
    private String username;
    private String password;
    private String userID;

    private List<Account> accounts;

    public User(String name, String IC_No, String birthday, String gender, String nationality, String race, String religion, String telNo, String address, String username, String password, String userID) {
        this.name = name;
        this.IC_No = IC_No;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.race = race;
        this.religion = religion;
        this.telNo = telNo;
        this.address = address;
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.accounts = new ArrayList<>();
    }


    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public double getTotalBalance() {
        double total = 0.0;

        for (Account acc : this.accounts) {
            total = total + acc.getBalance();
        }

        return total;
    }

    // Getter
    public String getName() {return this.name;}

    public String getIC_No() {return this.IC_No;}

    public String getBirthday() {return this.birthday;}

    public String getGender() {return this.gender;}

    public String getNationality() {return this.nationality;}

    public String getRace() {return this.race;}

    public String getReligion() {return this.religion;}

    public String getTelNo() {return this.telNo;}

    public String getAddress() {return this.address;}

    public String getUsername() {return this.username;}

    public String getPassword() {return this.password;}

    public String getUserID() {return this.userID;}

    public List<Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public String toString() {
        return "User: " + username + " | Total Accounts: " + accounts.size();
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setIC_No(String IC_No) {
        this.IC_No = IC_No;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void convertAccounts() {
        if (this.accounts == null ) return;

        for (int i = 0; i < accounts.size(); i++) {
            Account current = accounts.get(i);
            if ("Savings".equalsIgnoreCase(current.getType()) && !(current instanceof SavingsAccount)) {
                SavingsAccount smartAcc = new SavingsAccount(current.getAccountNumber(), current.getBalance());
                accounts.set(i, smartAcc);
            }

        }
    }
}
