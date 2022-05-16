package view;

import enums.MainMenuCommands;
import model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class MainMenu {
    private static MainMenu instance = null;

    private MainMenu() {
    }

    public static MainMenu getInstance() {
        if (instance == null)
            instance = new MainMenu();
        return instance;
    }

    public void run() {
        int a = 1;
        int count;
        ArrayList<User> users = null;
        String message;

        while (true) {
            String command = UtilityClass.read();
            Matcher matcher;
            if (command.equals("menu show-current"))
                System.out.println("Main Menu");
            else if (command.equals("menu exit"))
                break;
            else if (command.equals("user logout")) {
                System.out.println(MainMenuController.getInstance().logoutUser());
                break;
            } else if ((matcher = MainMenuCommands.isMatch(command, MainMenuCommands.ENTER_MENU)) != null) {
                message = MainMenuController.getInstance().enterMenu(matcher);
                if (message.equals("")) {
                    a = 2;
                    break;
                }
                System.out.println(message);
            } else if (MainMenuCommands.isMatch(command, MainMenuCommands.PLAY_GAME) != null) {
                if ((count = MainMenuController.getInstance().checkIsValidPlayGame(command)) == -1)
                    System.out.println("invalid command");
                else if ((users = MainMenuController.getInstance().checkIsValidUsername(count,command)) == null)
                    System.out.println("some usernames are invalid");
                else {
                    a = 3;
                    break;
                }
            } else
                System.out.println("invalid command");
        }

        if (a == 1)
            LoginMenu.run();
        else if (a == 2)
            ProfileMenu.run();
        else
            GameMenu.getInstance().run(users);
    }
}
