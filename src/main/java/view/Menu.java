package view;

public abstract class Menu {
    protected String name;


    protected Menu(String name){
        this.name = name;
    }


    public void showCurrentMenu(){
        System.out.println(this.name);
    }

    public abstract void run();

    public abstract void enterMenu(String menuName);

    public abstract void menuExit();

}
