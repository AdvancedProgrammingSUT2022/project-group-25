package model;

public class Tile {
    private int x, y;
    private TerrainAndFeature terrain;
    private TerrainAndFeature feature;
    private Resource resource;
    private Unit civilian;
    private MilitaryUnit militaryUnit;
    private boolean isThereCitizen;
    private Improvement improvement;
    private int movementCost;
    private int value = 0;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.terrain = null;
        this.feature = null;
        this.resource = null;
    }

    public void setTerrain(TerrainAndFeature terrain) {
        this.terrain = terrain;
    }

    public void setFeature(TerrainAndFeature feature) {
        this.feature = feature;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setCivilian(Unit civilian) {
        this.civilian = civilian;
    }

    public void setMilitaryUnit(MilitaryUnit militaryUnit) {
        this.militaryUnit = militaryUnit;
    }

    public TerrainAndFeature getTerrain() {
        return terrain;
    }

    public TerrainAndFeature getFeature() {
        return feature;
    }

    public Resource getResource() {
        return resource;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MilitaryUnit getMilitaryUnit() {
        return militaryUnit;
    }

    public int getMovementCost() {
        return movementCost;
    }

    public Unit getCivilian() {
        return civilian;
    }

    public boolean isThereCitizen() {
        return isThereCitizen;
    }

    public void setThereCitizen(boolean thereCitizen) {
        isThereCitizen = thereCitizen;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}