package procedure03.BiodomeFamily03;

public class Plant extends Organism {
    private String bloomSeason;
    private String hasFruit;

    public Plant(String name, String species, String field, String bloomSeason, String hasFruit) {
        super(name, species, field);
        this.bloomSeason = bloomSeason;
        this.hasFruit = hasFruit;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", " + getBloomSeason() + ", " + getHasFruit());
    }

    public String getBloomSeason() {
        return bloomSeason;
    }

    public String getHasFruit() {
        return hasFruit;
    }
}
