package view;

import controller.LoginMenuController;
import controller.UtilityClass;
import enums.LoginMenuCommands;

import java.util.regex.Matcher;

public class LoginMenu {
    private static LoginMenu instance = null;


    public static LoginMenu getInstance() {
        if (instance == null)
            instance = new LoginMenu();
        return instance;
    }


    public static void run() {
        String message;
        while (true) {
            String command = UtilityClass.read();
                    Matcher matcher;
            if ((matcher = LoginMenuCommands.isMatchCreateUser(command)) != null)
                System.out.println(LoginMenuController.getInstance().createUser(matcher));
            else if ((matcher = LoginMenuCommands.isMatchLoginUser(command)) != null)
                System.out.println(LoginMenuController.getInstance().loginUser(matcher));
            else if (command.equals("menu exit")) {
                //LoginController.getInstance().writeUserInfo();
                System.exit(0);
            } else if (command.equals("menu show-current"))
                System.out.println("Login menu");
            else if ((matcher = LoginMenuCommands.isMatch(command, LoginMenuCommands.ENTER_MENU)) != null) {
                message = LoginMenuController.getInstance().enterMenu(matcher);
                if (message.equals(""))
                    break;
                System.out.println(message);
            } else
                System.out.println("invalid command");
        }
        MainMenu.getInstance().run();
    }
}
