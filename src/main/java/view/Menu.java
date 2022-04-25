package view;

import model.User;

public abstract class Menu {
    protected String name;
    public static User loggedInUser;

    protected Menu(String name){
        this.name = name;
    }


    public void showCurrentMenu(){
        System.out.println(this.name);
    }

    public abstract void run();

    public String getName() {
        return name;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Menu.loggedInUser = loggedInUser;
    }
}
