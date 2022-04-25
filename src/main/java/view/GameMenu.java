package view;


import model.User;

import java.util.ArrayList;

public class GameMenu extends Menu{
    ArrayList<User>players;

    GameMenu(ArrayList<User>users){
        super("game Menu");
        players = users;
    }

    @Override
    public void run() {

    }



}
