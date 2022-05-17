package Controller;

import Controller.GameControllerPackage.GameDataBase;
import MenuRegex.MainMenuRegex;
import Model.User;
import View.CurrentMenu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;

public class MainMenuController extends Controller {

    @Override
    public String menuNavigate(Matcher matcher) {
        String menu = matcher.group("menuname");
        if (Objects.equals(menu, "Game menu"))
            return "use play game method";
        if (Objects.equals(menu, "Profile menu")) {
            CurrentMenu.set(CurrentMenu.ProfileMenu);
            return "entered Profile menu";
        }
        if (Objects.equals(menu, "Login menu"))
            return "use logout method";
        return "menu name is not valid";
    }

    public String logout() {
        UserDatabase.setCurrentUser(null);
        CurrentMenu.set(CurrentMenu.LoginMenu);
        return "user logged out successfully";
    }

    public String playGame(String input) {
        ArrayList<String> usernames = MainMenuRegex.PlayGameRegexConvertToPlayers(input);
        if (usernames == null) return "you entered wrong number";
        ArrayList<User> users = new ArrayList<>();
        for (String username : usernames) {
            if (UserDatabase.findUserByUsername(username) == null)
                return "user with username " + username + " doesn't exist";
            users.add(UserDatabase.findUserByUsername(username));
        }
        if (users.size() <= 1)
            return "number of players must be at least 2";
        GameDataBase.runGameForFirstTime(users);
        CurrentMenu.set(CurrentMenu.GameMenu);
        return "you entered Game Menu";
    }
}
