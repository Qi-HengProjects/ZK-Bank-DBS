package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class DataManager {
    private static final String FILE_PATH = "bank_data.json";
    private Gson gson; // Java 和 json 的google translate

    // setup 一个data manager
    public DataManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        // setPrettyPrinting() 让json比较容易读
        // .create()  setup 然后让我们用
    }

    // SAVE ram --> ssd
    public void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) { // 把data 进去bank_data.json, 用try因为java会自动关file
            gson.toJson(users, writer); // 把那个list写进 json file
            System.out.println("Bank data saved successfully!"); // 显示成功save
        } catch (IOException e){ // 确保有什么error的话code不会crash
            e.printStackTrace(); // 把error print出来
        }
    }

    // LOAD ssd --> ram
    public List<User> loadUsers() {
        File file = new File(FILE_PATH); // create一个 file object
        if (!file.exists()) { // 如果没有那个file， return空的list
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(FILE_PATH)) { // 把file开起来读取
            Type listType = new TypeToken<ArrayList<User>>(){}.getType(); // list的蓝图
            return gson.fromJson(reader, listType); // translate 了根据list的蓝图build出来
        } catch (IOException e) {
            e.printStackTrace(); // 确保有什么error的话code不会crash
            return new ArrayList<>();
        }
    }

}

// 运作原理：
// 1. 把整个file打开 读里面的data
// 2. 把file的data和最新要加的东西 copy进ram 然后清空file
// 3. 把在ram里面的新版data写进file

