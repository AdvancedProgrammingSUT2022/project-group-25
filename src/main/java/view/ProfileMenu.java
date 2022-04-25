package view;


import controller.ProfileMenuController;
import model.CommandRegexes;
import model.UtilityClass;

import java.util.regex.Matcher;

public class ProfileMenu extends Menu {
    private final ProfileMenuController profileMenuController = new ProfileMenuController();
    private static String command;
    private static Matcher matcher;


    ProfileMenu() {
        super("profile Menu");
    }

    @Override
    public void run() {
        while (true) {
            command = UtilityClass.read();
            if (command.equals("menu exit"))
                break;
            else if (command.equals("menu show-current"))
                UtilityClass.write(super.getName());
            else if (CommandRegexes.menuEnterRegex(command, "menu enter ((main|game|login) Menu)").find())
                UtilityClass.write("menu navigation is not possible");
            else if ((matcher = CommandRegexes.nicknameChangeRegex(command)).find())
                UtilityClass.write(profileMenuController.changeNickname(matcher));
            else if ((matcher = CommandRegexes.changePasswordRegex(command)).find())
                UtilityClass.write(profileMenuController.changePassword(matcher));
            else
                UtilityClass.write("invalid command");
        }
        new MainMenu().run();
    }


}
