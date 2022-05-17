package Model.Units;

import Model.Civilization;
import Model.Terrains.Terrain;

public class SiegeMilitaryUnit extends MilitaryUnit {

    private boolean isInSiege;

    public SiegeMilitaryUnit(UnitType myType, Terrain terrain, Civilization civilization) {
        super(myType, terrain, civilization);
    }

    public void setUp() {
        isInSiege = true;
        setWorkDone(true);
    }

    public boolean isInSiege() {
        return isInSiege;
    }

    public void setInSiege(boolean inSiege) {
        isInSiege = inSiege;
    }
}
