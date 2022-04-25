package controller;


import model.User;
import view.Menu;

import java.util.ArrayList;
import java.util.regex.Matcher;


public class LoginController {


    public String registerUser(Matcher matcher) {
            String name = matcher.group(2);
            String password = matcher.group(4);
            String nickname = matcher.group(6);
        return checkUserExist(name, password, nickname);
    }

    private String checkUserExist(String name, String password, String nickname) {
        ArrayList<User> users = User.getUsers();
        for (User user : users) {
            if (user.getName().equals(name))
                return "user with username " + name + " already exists";
            else if (user.getNickname().equals(nickname))
                return "user with nickname " + nickname + " already exists";
        }
        return createUser(name, password, nickname);
    }

    private String createUser(String name, String password, String nickname) {
        new User(name, password, nickname);
        return "user successfully created";
    }


    public String loginUser(Matcher matcher) {
        String name = matcher.group(2);
        String password = matcher.group(4);
        ArrayList<User> users = User.getUsers();
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password))
                user.setLoggedIn(true);
                Menu.loggedInUser = user;
                return "user logged in";
        }
        return "username and password did not match";
    }
}
