package View;

import java.util.Scanner;

import Controller.MainMenuController;
import MenuRegex.MainMenuRegex;

public class MainMenuView extends View {
    private final MainMenuController MainMenuController;

    public MainMenuView(Scanner scanner, MainMenuController mainMenuController) {
        super(scanner);
        this.MainMenuController = mainMenuController;
    }

    @Override
    public void run() {

        while (CurrentMenu.get() == CurrentMenu.MainMenu) {
            input = scanner.nextLine();
            if ((matcher = MainMenuRegex.getMatcher(input, MainMenuRegex.ENTER)) != null)
                System.out.println(MainMenuController.menuNavigate(matcher));
            else if ((matcher = MainMenuRegex.getMatcher(input, MainMenuRegex.EXIT)) != null)
                System.out.println("log out please");
            else if ((matcher = MainMenuRegex.getMatcher(input, MainMenuRegex.SHOW_CURRENT_MENU)) != null)
                System.out.println(CurrentMenu.get());
            else if ((matcher = MainMenuRegex.getMatcher(input, MainMenuRegex.LOGOUT)) != null)
                System.out.println(MainMenuController.logout());
            else if ((matcher = MainMenuRegex.getMatcher(input, MainMenuRegex.PLAY_GAME)) != null)
                System.out.println(MainMenuController.playGame(input));
            else
                System.out.println("invalid command");
        }

    }
}
