package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Consumer;
import static java.lang.Integer.parseInt;

public class DataManager {
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    private String fileName;
    private Gson gson; // Java 和 json 的google translate

    // setup 一个data manager
    public DataManager(String fileName) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.fileName = fileName;
        // setPrettyPrinting() 让json比较容易读

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

            for (User u : users) {
                u.convertAccounts();
            }

            return users;

        } catch (IOException e) {
            e.printStackTrace(); // 确保有什么error的话code不会crash
            return new ArrayList<>();
        }

    }

     public void SaveUser(User newUser){
        try {
            List<User> users = loadUsers();
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
        try{
            List<User> users = loadUsers();

            for (User user : users) {
                if (Objects.equals(user.getUserID(), targetID)) {
                    String before = getter.apply(user);
                    System.out.println("Before" + before);
                    setter.accept(user);
                    System.out.println("After: " + getter.apply(user));
                    break;
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(gsonPretty.toJson(users));
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    /*
    public void saveUser(User user) {
        try {
            checkFile(new File(fileName));
            JsonObject stuff = new JsonObject();
            JsonObject father = new JsonObject();
            father.addProperty("userID", user.getUsername());
            father.add("accounts", stuff);
            stuff.addProperty("accountNumber", user.getPassword());

            PrintWriter saveJSon = new PrintWriter(new FileWriter(fileName));
            saveJSon.println(gsonPretty.toJson(father));
            saveJSon.close();
        } catch (Exception e) {
            System.out.println("Error while saving user!");
            e.printStackTrace();
        }
    }

     */



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
            int idNum = Integer.parseInt(id.trim());
            if (idNum > largestIDnum) {
                largestIDnum = idNum;
            }
        }
        int newIDnum = largestIDnum +1;
        return "U" + String.format("%03d", newIDnum);
    }

    public String generateAccountID(List<User> u) {
        int largestAccNum = 0;
        for (User user : u) {
            if (user.getAccounts() != null) {
                for (Account acc : user.getAccounts()){
                    if (acc != null) {
                        try {
                            int accNum = Integer.parseInt(acc.getAccountNumber().trim());
                            if (accNum > largestAccNum) {
                                largestAccNum = accNum;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("skipping this invalid account number: " + acc.getAccountNumber());
                        }
                    }
                }
            }
        }
        int newAccNum = largestAccNum +1;
        return String.format("%08d", newAccNum);
    }

    public void addNewAccount(String type, double balance) {
        List<User> users = loadUsers();
        for (User user : users) {
            if (Objects.equals(user.getUserID(), Main.currentSession)) {
                user.addAccount(new Account(generateAccountID(users), type, balance));
                break;
            }
        }
        saveAll(users);
    }
}


