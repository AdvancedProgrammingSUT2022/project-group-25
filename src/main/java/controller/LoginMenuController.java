package controller;

import model.User;

import java.util.regex.Matcher;

public class LoginMenuController {

    private static LoginMenuController instance = null;

    private LoginMenuController() {
    }

    public static LoginMenuController getInstance() {
        if (instance == null) {
            instance = new LoginMenuController();
            //readUserInfo();
        }
        return instance;
    }

    public String createUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");

        if (MainMenuController.getInstance().isExistUsername(username) != null)
            return "user with username " + username + " already exists";
        if (ProfileMenuController.getInstance().isExistNickname(nickname) != null)
            return "user with nickname " + nickname + " already exists";
        User user = new User(username, password, nickname);
        return "user created successfully!";
    }

    public String loginUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");

        User user;
        if ((user = MainMenuController.getInstance().isExistUsername(username)) == null)
            return "Username and password didn’t match!";
        if (!user.getPassword().equals(password))
            return "Username and password didn’t match!";
        User.setLoggedInUser(user);
        return "user logged in successfully!";
    }

    public String enterMenu(Matcher matcher) {
        String menuName = matcher.group("menuName");
        if (User.getLoggedInUser() == null)
            return "please login first";
        if (menuName.equals("Main Menu"))
            return "";
        return "menu navigation is not possible";
    }
}
