package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.User;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilityClass {
    private static UtilityClass utilityClass = null;
    private static Scanner scanner;


    private UtilityClass() {
        scanner = new Scanner(System.in);
    }

    public static UtilityClass getInstance() {
        if (utilityClass == null) {
            utilityClass = new UtilityClass();
        }
        return utilityClass;

    }

    public void writeUsers(ArrayList<User> users) {
        try (Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/users.json"), StandardCharsets.UTF_8)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (Exception e) {
            write(e.getMessage());
        }
    }


    public void readUsers() {
        String fileName = "src/main/resources/users.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            ArrayList<User> users = gson.fromJson(reader,
                    new TypeToken<ArrayList<User>>() {
                    }.getType());
            User.setAllUsers(users);

        } catch (IOException e) {
            write(e.getMessage());
        }

    }

    public static void write(String message) {
        System.out.println(message);
    }

    public static String read() {
        return scanner.nextLine();
    }

}
