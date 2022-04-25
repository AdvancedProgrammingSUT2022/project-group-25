package controller;

import model.User;
import view.Menu;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class ProfileMenuController{
    private final User loggedInUser = Menu.getLoggedInUser();

    public  String changeNickname(Matcher matcher) {
        String nickname = matcher.group("nickname");
        if (isExistNickname(nickname) != null)
            return "user with nickname " + nickname + " already exists";
        loggedInUser.setNickname(nickname);
        return "nickname changed successfully!";
    }

    public  String changePassword(Matcher matcher) {
        String currentPassword = matcher.group("currentPassword");
        String newPassword = matcher.group("newPassword");
        if (loggedInUser.getPassword().equals(currentPassword))
            return "current password is invalid";
        if (loggedInUser.getPassword().equals(newPassword))
            return "please enter a new password";
        loggedInUser.setPassword(newPassword);
        return "password changed successfully!";
    }



    public  User isExistNickname(String nickname) {
        ArrayList<User> users = User.getUsers();
        for (User user : users) {
            if (user.getNickname().equals(nickname))
                return user;
        }
        return null;
    }

}
