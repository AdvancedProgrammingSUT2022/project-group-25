package view;


import controller.GameMenuController;
import model.User;

import java.util.ArrayList;

public class GameMenu extends Menu{
    GameMenuController gameMenuController;


    GameMenu(ArrayList<User>users){
        super("game Menu");
        gameMenuController = new GameMenuController(users);
    }

    @Override
    public void run() {

    }



}
