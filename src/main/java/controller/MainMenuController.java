package controller;

import model.CommandRegexes;
import model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController{

    public static int countMatches(String input) {
        Matcher matcher = Pattern.compile("(p|-player)[0-9]+ (?<username>\\S+)").matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int checkIsValidPlayGame(String command) {
        int count = countMatches(command);
        if (count < 2)
            return -1;
        for (int i = 1; i <= count; i++) {

            if (!CommandRegexes.playerRegexCheck(command, i).find())
                return -1;
        }
        return count;
    }

    public static ArrayList<User> checkIsValidUsername(int count, String command) {
        ArrayList<User> users = new ArrayList<>();
        User user;
        for (int i = 1; i <= count; i++) {
            Matcher matcher = Pattern.compile("-(p|-player)" + i + " (?<username>\\S+)").matcher(command);
            if (matcher.find()) {
                String username = matcher.group("username");
                if ((user = isExistUsername(username)) == null)
                    return null;
                users.add(user);
            }
        }
        return users;
    }

    private static User isExistUsername(String username) {
    }


}
