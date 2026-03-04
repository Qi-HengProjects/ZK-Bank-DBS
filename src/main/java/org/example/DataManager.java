package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

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
            return gson.fromJson(reader, listType); // translate 了根据list的蓝图build出来
        } catch (IOException e) {
            e.printStackTrace(); // 确保有什么error的话code不会crash
            return new ArrayList<>();
        }

    }

     public void saveUser(User user) {
        try {
            checkFile(new File(fileName));
            JsonObject father = new JsonObject();
            JsonObject stuff = new JsonObject();
            father.addProperty("name", user.getName());
            father.addProperty("IC_No", user.getIC_No());
            father.addProperty("birthday", user.getBirthday());
            father.addProperty("gender", user.getGender());
            father.addProperty("nationality", user.getNationality());
            father.addProperty("race", user.getRace());
            father.addProperty("religion" , user.getReligion());
            father.addProperty("telNo" , user.getTelNo());
            father.addProperty("address" , user.getAddress());
            father.addProperty("username" , user.getUsername());
            father.addProperty("password" , user.getPassword());
            father.addProperty("userID" , user.getUserID());
            father.add("accounts", stuff);

            PrintWriter saveJSon= new PrintWriter(new FileWriter(fileName));
            saveJSon.println(gsonPretty.toJson(father));
            saveJSon.close();

        } catch (Exception e) {
            System.out.println("Error while saving user!");
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
}

// 运作原理：(need update)
// 1. 把整个file打开 读里面的data
// 2. 把file的data和最新要加的东西 copy进ram 然后清空file
// 3. 把在ram里面的新版data写进file
