import controller.UtilityClass;
import model.Unit;
import view.LoginMenu;

public class Main {
    public static void main(String[] args) {
        UtilityClass.getInstance().readUsers();
        LoginMenu.getInstance().run();
    }
}