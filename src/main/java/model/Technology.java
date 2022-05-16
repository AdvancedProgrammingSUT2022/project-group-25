package model;

public class Technology {
    private static List<TechnologyEnum> allTechnologies = Arrays.asList(TechnologyEnum.values());
    private String type;
    private String name;
    private int cost;
    private ArrayList<Technology> neededTechnologies;
    public Technology(TechnologyEnum type) {
        this.type = type.getType();
        this.name = type.getName();
        this.cost = type.getCost();
        this.neededTechnologies = type.getNeededTechnologies();

    }

    public String getType() {
        return type;
    }

    public String getName() {

    }
}
