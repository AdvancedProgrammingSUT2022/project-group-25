package view;

import model.User;

public abstract class Menu {
    protected String name;
    protected User loggedInUser;

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

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
