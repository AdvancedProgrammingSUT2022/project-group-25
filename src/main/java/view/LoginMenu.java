package view;

import controller.LoginController;

import java.util.Scanner;

public class LoginMenu extends Menu {

    private final LoginController loginController = new LoginController();
    private static final Scanner scanner = new Scanner(System.in);

    public LoginMenu() {
        super("login Menu");
    }


    @Override
    public void run() {

    }

    @Override
    public void enterMenu(String menuName) {

    }

    @Override
    public void menuExit() {

    }


}
