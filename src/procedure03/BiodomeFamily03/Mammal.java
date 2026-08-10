package procedure03.BiodomeFamily03;

public class Mammal extends Animal {
    private String warmBlooded;

    public Mammal(String name, String species, String field, String digest, String feed, String warmBlooded) {
        super(name, species, field, digest, feed);
        this.warmBlooded = warmBlooded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", " + giveBirth());
    }
    public String giveBirth() {
        return this.warmBlooded;
    }
}
