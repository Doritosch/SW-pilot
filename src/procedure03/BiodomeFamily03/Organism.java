package procedure03.BiodomeFamily03;

public class Organism {
    private String name;
    private String species;
    private String field;

    public Organism(String name, String species, String field) {
        this.name = name;
        this.species = species;
        this.field = field;
    }
    public void displayInfo() {
        System.out.print(getName() + ", " + getSpecies() + ", " + getField());
    }
    public String getName() {
        return this.name;
    }
    public String getSpecies() {
        return this.species;
    }
    public String getField() {
        return this.field;
    }
}
