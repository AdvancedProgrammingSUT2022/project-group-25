package controller;

import model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController {

    private static MainMenuController instance = null;

    private MainMenuController(){
    }

    public static MainMenuController getInstance() {
        if (instance == null)
            instance = new MainMenuController();
        return instance;
    }

    public String logoutUser() {
        User.setLoggedInUser(null);
        return "user logged out successfully!";
    }

    public String enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (menuName.equals("Profile Menu"))
            return "";
        else
            return "menu navigation is not possible";
    }

    public int checkIsValidPlayGame(String command) {
        int count = MainMenuCommands.countMatches(command);
        if (count < 2)
            return -1;
        for (int i = 1; i <= count; i++) {
            Matcher matcher = Pattern.compile("-(p|-player)" + i + " (?<username>\\S+)").matcher(command);
            if (!matcher.find())
                return -1;
        }
        return count;
    }

    public ArrayList<User> checkIsValidUsername(int count,String command) {
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

    public User isExistUsername(String username) {
        ArrayList<User> users = User.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }
}
