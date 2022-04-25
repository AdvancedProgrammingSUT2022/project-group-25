package view;

import controller.MainMenuController;
import model.CommandRegexes;
import model.User;
import model.UtilityClass;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class MainMenu extends Menu {

    private final MainMenuController mainMenuController = new MainMenuController();
    private Matcher matcher;
    String command;

    public MainMenu() {
        super("main Menu");
    }


    @Override
    public void run() {
        int count;
        ArrayList<User> players;
        while (true) {
            command = UtilityClass.read();
            if (command.equals("menu show-current"))
                UtilityClass.write(super.name);
            else if (command.equals("menu exit"))
                break;
            else if (command.equals("user logout")) {
                Menu.setLoggedInUser(null);
                break;
            } else if (command.startsWith("menu enter")) {
                matcher = CommandRegexes.menuEnterRegex(command,"menu enter (login|game|profile) Menu");
                if (matcher.find()) {
                    enterMenu(matcher.group(1));
                }
            } else if (command.startsWith("play game")) {
                if ((count = MainMenuController.checkIsValidPlayGame(command)) == -1)
                    System.out.println("invalid command");
                else if ((players = MainMenuController.checkIsValidUsername(count, command)) == null)
                    System.out.println("some usernames are invalid");
                else {
                    GameMenu gameMenu = new GameMenu(players);
                    gameMenu.run();
                }
            }


        }

    }

    private void enterMenu(String group) {
        switch (group) {
            case "game":
                UtilityClass.write("navigation is not possible");
                break;
            case "profile":
                ProfileMenu profileMenu = new ProfileMenu();
                profileMenu.run();
                break;
            case "login":
                UtilityClass.write("please first log out");
                break;
        }
    }


}
