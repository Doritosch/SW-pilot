package procedure03.BiodomeFamily01;

public class Organism {
    String name;
    String species;
    String field;

    public Organism(String name, String species, String field) {
        this.name = name;
        this.species = species;
        this.field = field;
    }
    public void displayInfo() {
        System.out.println(this.name + ", " + this.species + ", " + this.field);
    }

    public void setField(String field) {
        this.field = field;
    }
}
