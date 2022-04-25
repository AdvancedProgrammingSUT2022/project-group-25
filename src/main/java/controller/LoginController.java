package controller;


import model.User;
import view.Menu;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class LoginController {


    public String registerUser(Matcher matcher) {
        String name = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");
        return checkUserExist(name, password, nickname);
    }

    private String checkUserExist(String name, String password, String nickname) {
        ArrayList<User> users = User.getUsers();
        for (User user : users) {
            if (user.getName().equals(name))
                return "username already exists";
            else if (user.getNickname().equals(nickname))
                return "nickname already exists";
        }
        return createUser(name, password, nickname);
    }

    private String createUser(String name, String password, String nickname) {
        new User(name, password, nickname);
        return "user successfully created";
    }


}
