package view;

import controller.LoginController;
import model.CommandEnum;
import model.UtilityClass;

import javax.rmi.CORBA.Util;
import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends Menu {

    private final LoginController loginController = new LoginController();
    private static final Scanner scanner = new Scanner(System.in);

    public LoginMenu() {
        super("login Menu");
    }


    @Override
    public void run() {
        Matcher matcher;
        while (true) {
            String command = UtilityClass.read();
            if (command.startsWith("menu enter")) {
                UtilityClass.write("navigation not possible. login first.");
            } else if (command.startsWith("menu exit")) {
                System.exit(0);
            } else if (command.startsWith("user create")) {
                matcher = CommandEnum.userCreateRegex(command, "user_create");
                if (matcher != null) UtilityClass.write(loginController.registerUser(matcher));
            } else if (command.equals("menu show-current")) {
                UtilityClass.write(super.getName());
            } else if (command.startsWith("user login")) {
                matcher = CommandEnum.userLoginRegex(command, "user_login");
                if (matcher != null) UtilityClass.write(loginController.loginUser(matcher));
            }else UtilityClass.write("invalid command");
        }

    }


}
