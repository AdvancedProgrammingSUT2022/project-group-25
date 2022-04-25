package view;

import controller.LoginController;
import model.CommandRegexes;
import model.UtilityClass;

import java.util.regex.Matcher;

public class LoginMenu extends Menu {

    private final LoginController loginController = new LoginController();
    private static Matcher matcher;
    private String command;

    public LoginMenu() {
        super("login Menu");
    }


    @Override
    public void run() {
        while (true) {
            command = UtilityClass.read();
            if (command.startsWith("menu enter")) {
                UtilityClass.write("navigation not possible. login first.");
            } else if (command.startsWith("menu exit")) {
                System.exit(0);
            } else if (command.startsWith("user create")) {
                matcher = CommandRegexes.userCreateRegex(command);
                if (matcher.find()) UtilityClass.write(loginController.registerUser(matcher));
            } else if (command.equals("menu show-current")) {
                UtilityClass.write(super.getName());
            } else if (command.startsWith("user login")) {
                matcher = CommandRegexes.userLoginRegex(command);
                if (matcher.find()) {
                    UtilityClass.write(loginController.loginUser(matcher));
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.run();
                }
            } else UtilityClass.write("invalid command");
        }

    }


}
