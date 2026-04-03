package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
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

    // may need change
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

    public Object search(String target, String userID, String accountNumber, String loanID) {
        List<User> users = this.allusers;
        Object object = null;
        if (target.equalsIgnoreCase("Users")) {
            for (User user : users) {
                if (Objects.equals(userID, user.getUserID())) {
                    System.out.println("User existed!");
                    return user;
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
        String potentialID = null;
        Random newAcc = new Random();
        while (true) {
            int newAccountID = 10000000 + newAcc.nextInt(90000000);;
            potentialID = String.valueOf(newAccountID);
            Account result = (Account) search("Accounts", null, potentialID, null);
            if (result != null) {
                continue;
            } else {
                System.out.println("New account number generated!");
                break;
            }

        }
        return potentialID;
    }

    public void addNewAccount(String type, double balance) {
        User u = (User) search("Users", Main.currentSession, null, null);
        if (u != null){
            String accNum = generateAccountID();
            String date = java.time.LocalDate.now().toString();
            if (type.equalsIgnoreCase("Savings")) {
                SavingsAccount sa = new SavingsAccount(accNum, balance, date);
                u.addSavingAccount(sa);
            } else if (type.equalsIgnoreCase("Current")) {
                CurrentAccount ca = new CurrentAccount(accNum, balance, date);
                u.addCurrentAcccount(ca);
            }
            saveAll(this.allusers);
        }
    }

    public void performTransfer(String giveAccountNumber, String receiveAccountNumber, double amount) {
        Account ga = (Account) search("Accounts", null, giveAccountNumber, null);
        Account ra = (Account) search("Accounts", null, receiveAccountNumber, null);
        if (ga != null) {
            if (ra != null) {
                if (Objects.equals(giveAccountNumber, receiveAccountNumber)) {
                    System.out.println("You can not transfer to the same account!");
                } else {
                    if (ga.getType().equalsIgnoreCase("Current")) {
                        boolean deduct = ga.withdraw(amount);
                        if (deduct) {
                            System.out.println("RM " + amount + " has been deducted!");
                            System.out.println("RM " + ga.getBalance() + "Left in the account.");
                            ra.deposit(amount);
                            saveAll(allusers);
                        } else {
                            System.out.println("Transaction failed!");
                        }


                    } else {
                        System.out.println("You can only transfer to other user using a current account!");
                    }
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


