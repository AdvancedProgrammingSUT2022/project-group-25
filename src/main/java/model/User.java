package model;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private String nickname;
    private boolean isLoggedIn;
    private static final ArrayList<User> users = new ArrayList<>();
    private int score;
    private Civilization civilization;

    public User(String name, String nickname, String password) {
        setName(name);
        setNickname(nickname);
        setPassword(password);
        users.add(this);
    }


    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }
}
