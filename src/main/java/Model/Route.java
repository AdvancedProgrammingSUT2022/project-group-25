package Model;

import Controller.GameControllerPackage.GameDataBase;

import java.util.ArrayList;

public class Route {
    ArrayList<Coordination> coordination;
    int mp;

    public Route(){
        coordination = new ArrayList<>();
        mp = 0;
    }

    public void addTerrain(int x, int y) {
        coordination.add(new Coordination(x, y));
        mp += GameDataBase.getMainMap().getTerrain(x, y).getMp();
    }

    public ArrayList<Coordination> getRouteCoordinations() {
        return coordination;
    }

    public int getMp() {
        return mp;
    }
}