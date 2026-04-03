package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sun.jdi.request.ClassUnloadRequest;

import java.io.*;
import java.util.*;
import java.lang.reflect.Type;
import java.util.function.Function;
import java.util.function.Consumer;
import static java.lang.Integer.parseInt;
import java.util.random.*;

public class DataManager {
    private List<User> allusers = new ArrayList<>();
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    private String fileName;
    private Gson gson; // Java 和 json 的google translate

    // setup 一个data manager
    public DataManager(String fileName) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.fileName = fileName;
        // setPrettyPrinting() 让json比较容易读
        this.allusers = loadUsers();
        // .create()  setup 然后让我们用

    }

    // LOAD ssd --> ram

    public List<User> loadUsers() {

        if (!checkFile(new File(fileName))) return new ArrayList<>();

        try (FileReader reader = new FileReader(fileName)) { // 把file开起来读取
            Type listType = new TypeToken<ArrayList<User>>(){}.getType(); // list的蓝图
            List<User> users = gson.fromJson(reader, listType);// translate 了根据list的蓝图build出来

            if (users == null) {
                return new ArrayList<>();
            }
            return users;

        } catch (IOException e) {
            e.printStackTrace(); // 确保有什么error的话code不会crash
            return new ArrayList<>();
        }
    }



     public void SaveUser(User newUser){
        try {
            List<User> users = this.allusers;
            for (User user : users) {
                if (Objects.equals(newUser.getUsername(), user.getUsername())){
                    System.out.println("This username has been used");
                    return;
                }
            }
            users.add(newUser);
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(gsonPretty.toJson(users));
            writer.close();
        } catch (Exception e){
            System.out.println("Error while saving user!");
            e.printStackTrace();
        }
    }



    public void saveAll(List<User> u) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            writer.println(gsonPretty.toJson(u));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void updateData(String targetID, Function<User, String> getter, Consumer<User> setter) {
        List<User> users = this.allusers;

        for (User user : users) {
            if (Objects.equals(user.getUserID(), targetID)) {
                String before = getter.apply(user);
                System.out.println("Before" + before);
                setter.accept(user);
                System.out.println("After: " + getter.apply(user));
                saveAll(this.allusers);
                break;
            }
        }
    }



    public Object search(String target, String userID, String accountNumber, String loanID, String transactionID) {
        List<User> users = this.allusers;
        if (target.equalsIgnoreCase("Users")) {
            for (User user : users) {
                if (Objects.equals(userID, user.getUserID())) {
                    System.out.println("User existed!");
                    return user;
                }
            }
        }

         if (target.equalsIgnoreCase("UsersWithAccount")) {
             for (User user : users) {
                 for (SavingsAccount sa : user.getSavingsAccounts()) {
                    if(Objects.equals(sa.getAccountNumber(), accountNumber)) {
                        return user;
                    }
                 }

                 for (CurrentAccount ca : user.getCurrentAccounts()) {
                     if(Objects.equals(ca.getAccountNumber(), accountNumber)) {
                         return user;
                     }
                 }
             }
         }

        if (target.equalsIgnoreCase("Accounts")) {
            for (User user : users) {
                for (SavingsAccount sa : user.getSavingsAccounts()) {
                    if (Objects.equals(accountNumber, sa.getAccountNumber())) {
                        System.out.println("Accounts existed");
                        return sa;
                    }
                }

                for  (CurrentAccount ca : user.getCurrentAccounts()) {
                    if (Objects.equals(accountNumber, ca.getAccountNumber())) {
                        System.out.println("Account existed");
                        return ca;
                    }
                }
            }
        }


        if (target.equalsIgnoreCase("Loans")) {
            for (User user : users) {
                for (Loan loan : user.getLoans()) {
                    if (Objects.equals(loanID, loan.getLoanID())) {
                        System.out.println("Loan existed");
                        return loan;
                    }
                }
            }
        }

        if (target.equalsIgnoreCase("Transactions")) {
            for (User user : users) {
                for (Transaction transaction : user.getTransactions()) {
                    if (Objects.equals(transactionID, transaction.getTransactionID())) {
                        System.out.println("Loan existed");
                        return transactionID;
                    }
                }
            }
        }

        return null;
    }



    private boolean checkFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return file.exists();
    }

    public String generateUserID() {
        List<User> users = loadUsers();
        int largestIDnum = 0;
        for (User user : users) {
            String id = user.getUserID().substring(1);
            int idNum = parseInt(id.trim());
            if (idNum > largestIDnum) {
                largestIDnum = idNum;
            }
        }
        int newIDnum = largestIDnum +1;
        return "U" + String.format("%03d", newIDnum);
    }



    public String generateAccountID() {
        String potentialID;
        Random newAcc = new Random();
        while (true) {
            int newAccountID = 10000000 + newAcc.nextInt(90000000);
            potentialID = String.valueOf(newAccountID);
            Account result = (Account) search("Accounts", null, potentialID, null, null);
            if (result != null) {
                System.out.println("Account number existed, generating a new one");
            } else {
                System.out.println("New account number generated!");
                break;
            }

        }
        return potentialID;
    }



    public String generateLoanID() {
        String potentialID;
        Random newLoan = new Random();
        while (true) {
            int newLoanID = 10000 + newLoan.nextInt(900000);
            potentialID = "L" + String.valueOf(newLoanID);
            Loan result = (Loan) search("Loans", null, null, potentialID, null);
            if (result != null) {
                System.out.println("LoanID existed, generating a new one");
            } else {
                System.out.println("New LoanID generated!");
                break;
            }
        }
        return potentialID;
    }

    public String generateTransactionID() {
        String potentialID;
        Random newTransaction = new Random();
        while (true) {
            int newTransactionID = 10000000 + newTransaction.nextInt(90000000);
            potentialID = "TXF" + String.valueOf(newTransactionID);
            Transaction result = (Transaction) search("Transaction", null, null, null, potentialID);
            if (result != null) {
                System.out.println("TransactionID existed, generating a new one");
            } else {
                System.out.println("New TransactionID generated!");
                break;
            }
        }
        return potentialID;
    }



    public void addNewAccount(String type, double balance) {
        User u = (User) search("Users", Main.currentSession, null, null, null);
        if (u != null){
            String accNum = generateAccountID();
            String date = java.time.LocalDate.now().toString();
            if (u.getApplicationStatus().equalsIgnoreCase("APPROVED")) {
                if (type.equalsIgnoreCase("Savings")) {
                    SavingsAccount sa = new SavingsAccount(accNum, balance, date);
                    u.addSavingAccount(sa);
                } else if (type.equalsIgnoreCase("Current")) {
                    CurrentAccount ca = new CurrentAccount(accNum, balance, date);
                    u.addCurrentAcccount(ca);
                }
                u.setAccountApplication("Not specified");
                u.setApplicationType("Not specified");
                u.setApplicationStatus("Not specified");
                saveAll(this.allusers);
            }
        }
    }



    public void addNewLoan(double loanAmount, double paymentAmount, String loanStatus, double interestRate, double monthlyInstallment, double loanPeriod) {
        User u = (User) search("Users", Main.currentSession, null, null, null);
        if (u != null) {
            String loanID = generateLoanID();
            String startingDate = java.time.LocalDate.now().toString();
            if (u.getRequestLoanStatus().equalsIgnoreCase("APPROVED")) {
                Loan loan = new Loan(loanID, loanAmount,  paymentAmount, loanStatus, interestRate, monthlyInstallment, loanPeriod, startingDate);
                u.addLoan(loan);
                u.setRequestLoanAmount("Not specified");
                u.setRequestLoanPeriod("Not specified");
                u.setRequestLoanStatus("Not specified");
                saveAll(this.allusers);
            }
        }
    }



    public void performTransfer(String giveAccountNumber, String receiveAccountNumber, double amount) {
        Account ga = (Account) search("Accounts", null, giveAccountNumber, null, null);
        Account ra = (Account) search("Accounts", null, receiveAccountNumber, null, null);
        User checkOwner = (User) search("UsersWithAccounts", null, giveAccountNumber, null, null);
        User checkReceiver = (User) search("UsersWithAccounts", null, receiveAccountNumber, null, null);

        if (ga != null) {
            if (ra != null) {
                if (checkOwner != null) {
                    if (checkReceiver != null) {
                        if (Objects.equals(giveAccountNumber, receiveAccountNumber)) {
                            System.out.println("You can not transfer to the same account!");
                        } else {
                            if (ga.getType().equalsIgnoreCase("Current")) {
                                boolean deduct = ga.withdraw(amount);
                                if (deduct) {
                                    ra.deposit(amount);
                                    saveAll(allusers);
                                    System.out.println("RM " + amount + " has been deducted!");
                                    System.out.println("RM " + ga.getBalance() + "Left in the account.");
                                } else {
                                    System.out.println("Transaction failed!");
                                }

                            } else if(ga.getType().equalsIgnoreCase("Savings")) {
                                if (Objects.equals(checkOwner.getUserID(), checkReceiver.getUserID())) {
                                    boolean deduct = ga.withdraw(amount);
                                    if (deduct) {
                                        ra.deposit(amount);
                                        saveAll(allusers);
                                        System.out.println("RM " + amount + " has been deducted!");
                                        System.out.println("RM " + ga.getBalance() + "Left in the account.");
                                    } else {
                                        System.out.println("Insufficient funds in Savings!");
                                    }
                                } else {
                                    System.out.println("You can only transfer money in savings account to your own account!");
                                }
                            }else {
                                System.out.println("You can only transfer to other user using a current account!");
                            }
                        }
                    } else {
                    System.out.println("Please make sure the receiving user existed");
                    }
                } else {
                    System.out.println("Please make sure the sending user existed");
                }
            } else {
                System.out.println("Receiver account not found");
                }
        } else {
            System.out.println("Sender account not found");
        }
    }



    public List<String[]> makeAccountApplicationList() {
        List<String[]> accountApplicationList = new ArrayList<>();
        List<User> users = this.allusers;
        for (User user : users) {
            if (!user.getAccountApplication().equalsIgnoreCase("Not specified")) {
                String[] userApplication =
                        {user.getUserID(),
                        user.getCompany(),
                        user.getOccupation(),
                        user.getIncomeSource(),
                        user.getGrossIncome(),
                        user.getNetIncome(),
                        user.getAccountApplication(),
                        user.getApplicationType(),
                        user.getApplicationStatus()};
                accountApplicationList.add(userApplication);
            }

        }
        return accountApplicationList;
    }



    public List<String[]> makeLoanApplicationList() {
        List<String[]> loanApplicationList = new ArrayList<>();
        List<User> users = this.allusers;
        for (User user : users) {
            if (!user.getRequestLoanAmount().equalsIgnoreCase("Not specified")) {
                String [] userApplication =
                        {user.getUserID(),
                        user.getCompany(),
                        user.getOccupation(),
                        user.getIncomeSource(),
                        user.getGrossIncome(),
                        user.getNetIncome(),
                        user.getRequestLoanAmount(),
                        user.getRequestLoanPeriod(),
                        user.getRequestLoanStatus()};
                loanApplicationList.add(userApplication);
            }
        }
        return loanApplicationList;
    }
}


