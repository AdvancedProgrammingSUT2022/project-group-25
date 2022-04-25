package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.NameList;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static void writeUsers(ArrayList<User> users) {
        try (Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/users.json"), StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (Exception e) {
            UtilityClass.write(e.getMessage());
        }
    }


    public static void readUsers() {
        String fileName = "src/main/resources/users.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            ArrayList<User> users = gson.fromJson(reader,
                    new TypeToken<ArrayList<User>>() {
                    }.getType());
            User.setUsers(users);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
