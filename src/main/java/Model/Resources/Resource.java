package Model.Resources;

import Model.Improvements.Improvement;
import Model.TechnologyPackage.TechnologyType;
import Model.TerrainFeatures.TerrainFeature;
import Model.Terrains.TerrainType;

import java.util.ArrayList;
import java.util.Arrays;

public enum Resource {
    BANANA(1, 0, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.JUNGLE);
    }}, Improvement.PASTURE, null, ResourceMainType.BONUS),

    CATTLE(1, 0, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
    }}, Improvement.PASTURE, null, ResourceMainType.BONUS),

    DEER(1, 0, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.FOREST);
        add(TerrainType.TUNDRA);
        add(TerrainType.HILLS);
    }}, Improvement.CAMP, null, ResourceMainType.BONUS),

    SHEEP(1, 0, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
        add(TerrainType.HILLS);
    }}, Improvement.PASTURE, null, ResourceMainType.BONUS),

    WHEAT(1, 0, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        //TODO add jolge
    }}, Improvement.FARM, null, ResourceMainType.BONUS),

    COAL(0, 1, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.HILLS);
    }}, Improvement.MINE, TechnologyType.SCIENTIFICTHEORY, ResourceMainType.STRATEGIC),

    HORSE(0, 1, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.TUNDRA);
    }}, Improvement.PASTURE, TechnologyType.ANIMALHUSBANDRY, ResourceMainType.STRATEGIC),

    IRON(0, 1, 0, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
        add(TerrainType.TUNDRA);
        add(TerrainType.SNOW);
        add(TerrainType.HILLS);
    }}, Improvement.MINE, TechnologyType.IRONWORKING, ResourceMainType.STRATEGIC),

    COTTON(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
    }}, Improvement.PLANTATION, null, ResourceMainType.LUXURY),

    DYES(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.JUNGLE);
        add(TerrainFeature.FOREST);
    }}, Improvement.PLANTATION, null, ResourceMainType.LUXURY),

    FURS(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.FOREST);
        add(TerrainType.TUNDRA);
    }}, Improvement.CAMP, null, ResourceMainType.LUXURY),

    GEMS(0, 0, 3, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.JUNGLE);
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
        add(TerrainType.TUNDRA);
        add(TerrainType.HILLS);
    }}, Improvement.MINE, null, ResourceMainType.LUXURY),

    GOLD(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
        add(TerrainType.HILLS);
    }}, Improvement.MINE, null, ResourceMainType.LUXURY),

    INCENSE(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
    }}, Improvement.PLANTATION, null, ResourceMainType.LUXURY),

    IVORY(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.PLAIN);
    }}, Improvement.CAMP, null, ResourceMainType.LUXURY),

    MARBLE(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.GRASSLAND);
        add(TerrainType.PLAIN);
        add(TerrainType.DESERT);
        add(TerrainType.TUNDRA);
        add(TerrainType.HILLS);
    }}, Improvement.QUARRY, null, ResourceMainType.LUXURY),

    SILK(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.FOREST);
    }}, Improvement.PLANTATION, null, ResourceMainType.LUXURY),

    SILVER(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainType.TUNDRA);
        add(TerrainType.DESERT);
        add(TerrainType.HILLS);
    }}, Improvement.MINE, null, ResourceMainType.LUXURY),

    SUGAR(0, 0, 2, new ArrayList<TerrainTypeOrTerrainFeatureType>() {{
        add(TerrainFeature.FLOODPLAINS);
        add(TerrainFeature.MARSH);
    }}, Improvement.PLANTATION, null, ResourceMainType.LUXURY);


    final private int food;
    final private int production;
    final private int gold;
    final private ArrayList<TerrainTypeOrTerrainFeatureType> canBeFoundOn;
    final private Improvement requiredImprovement;
    final private TechnologyType requiredTechnology;

    final ResourceMainType resourceMainType;

    Resource(int food, int production, int gold, ArrayList<TerrainTypeOrTerrainFeatureType> canBeFoundOn, Improvement requiredImprovement, TechnologyType requiredTechnology, ResourceMainType resourceMainType) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.canBeFoundOn = canBeFoundOn;
        this.requiredImprovement = requiredImprovement;
        this.requiredTechnology = requiredTechnology;
        this.resourceMainType = resourceMainType;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public ArrayList<TerrainTypeOrTerrainFeatureType> getCanBeFoundOn() {
        return canBeFoundOn;
    }

    public Improvement getRequiredImprovement() {
        return requiredImprovement;
    }

    public TechnologyType getRequiredTechnology() {
        return requiredTechnology;
    }

    public ResourceMainType getResourceMainType() {
        return resourceMainType;
    }


    public static ArrayList<Resource> getAllResources() {
        Resource[] yourEnums = Resource.class.getEnumConstants();
        return new ArrayList<>(Arrays.asList(yourEnums));
    }

    public static ArrayList<Resource> getLuxuryResources() {
        ArrayList<Resource> resources = new ArrayList<>();
        for (Resource allResource : getAllResources()) {
            if (allResource.getGold() != 0)
                resources.add(allResource);
        }
        return resources;
    }
}
