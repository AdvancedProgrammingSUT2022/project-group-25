import model.DataBase;
import view.LoginMenu;

public class Main {
    public static void main(String[] args) {
        DataBase.readUsers();
        new LoginMenu().run();
    }
}
