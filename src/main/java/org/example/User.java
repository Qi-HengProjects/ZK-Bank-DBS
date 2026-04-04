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
    private String company;
    private String occupation;
    private String incomeSource;
    private String grossIncome;
    private String netIncome;

    private String requestLoanAmount;
    private String requestLoanStatus;
    private String requestLoanPeriod;
    private String requestLoanPurpose;

    private String accountApplication;
    private String applicationStatus;
    private String applicationType;
    private List<SavingsAccount> savingsAccounts;
    private List<CurrentAccount> currentAccounts;
    private List<Transaction> transactions;
    private List<Loan> loans;

    public User(String name, String IC_No, String birthday, String gender, String nationality, String race,
                String religion, String telNo, String address, String username, String password, String userID,
                String company, String occupation, String incomeSource, String grossIncome, String netIncome,
                String requestLoanAmount, String requestLoanPeriod, String requestLoanStatus, String requestLoanPurpose,
                String accountApplication, String applicationType, String applicationStatus) {
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

        this.company = company;
        this.occupation = occupation;
        this.incomeSource = incomeSource;
        this.grossIncome = grossIncome;
        this.netIncome = netIncome;

        this.requestLoanAmount = requestLoanAmount;
        this.requestLoanPeriod = requestLoanPeriod;
        this.requestLoanStatus = requestLoanStatus;
        this.requestLoanPurpose = requestLoanPurpose;

        this.accountApplication = accountApplication;
        this.applicationType = applicationType;
        this.applicationStatus = applicationStatus;

        this.savingsAccounts = new ArrayList<>();
        this.currentAccounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addSavingAccount(SavingsAccount newSavingAccount) {
        this.savingsAccounts.add(newSavingAccount);
    }

    public void addCurrentAcccount(CurrentAccount newCurrentAccount) {
        this.currentAccounts.add(newCurrentAccount);
    }

    public void addLoan(Loan newLoan) {
        this.loans.add(newLoan);
    }

    public void addTransaction(Transaction newTransaction) {
        this.transactions.add(newTransaction);
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

    public String getOccupation() {return this.occupation;}

    public String getCompany() {return this.company;}

    public String getIncomeSource() {return this.incomeSource;}

    public String getGrossIncome() {return this.grossIncome;}

    public String getNetIncome() {return this.netIncome;}

    public String getRequestLoanAmount() {
        return this.requestLoanAmount;
    }

    public String getRequestLoanStatus() {
        return this.requestLoanStatus;
    }

    public String getRequestLoanPeriod() {
        return this.requestLoanPeriod;
    }

    public String getRequestLoanPurpose() {return this.requestLoanPurpose;}

    public String getAccountApplication() {
        return this.accountApplication;
    }

    public String getApplicationStatus() {
        return this.applicationStatus;
    }

    public String getApplicationType() {
        return this.applicationType;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return this.savingsAccounts;
    }

    public List<CurrentAccount> getCurrentAccounts() {return this.currentAccounts; }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public List<Loan> getLoans() {
        return this.loans;
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

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setCompany(String company) {this.company = company;}

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public void setAccountApplication(String accountApplication) {
        this.accountApplication = accountApplication;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public void setRequestLoanAmount(String requestLoanAmount) {
        this.requestLoanAmount = requestLoanAmount;
    }

    public void setRequestLoanStatus(String requestLoanStatus) {
        this.requestLoanStatus = requestLoanStatus;
    }

    public void setRequestLoanPeriod(String requestLoanPeriod){
        this.requestLoanPeriod = requestLoanPeriod;
    }

    public void setRequestLoanPurpose(String requestLoanPurpose){
        this.requestLoanPurpose = requestLoanPurpose;
    }
}
