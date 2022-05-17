import Controller.GameControllerPackage.GameMenuController;
import Controller.LoginMenuController;
import Controller.MainMenuController;
import Controller.ProfileMenuController;
import Controller.UserDatabase;
import View.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDatabase.loadUsers();
        startApplication();
        UserDatabase.saveUsers();
    }

    private static void startApplication() {
        Scanner scanner = new Scanner(System.in);
        LoginMenuView loginMenu = new LoginMenuView(scanner, new LoginMenuController());
        MainMenuView mainMenu = new MainMenuView(scanner, new MainMenuController());
        ProfileMenuView profileMenu = new ProfileMenuView(scanner, new ProfileMenuController());
        GameMenuView gameMenu = new GameMenuView(scanner, new GameMenuController());
        while (CurrentMenu.get() != CurrentMenu.EndGame) {
            loginMenu.run();
            mainMenu.run();
            profileMenu.run();
            gameMenu.run();
        }
    }
}
