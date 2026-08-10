package procedure03.BiodomeFamily03;

public class Fish extends Animal {
    private String finsCount;

    public Fish(String name, String species, String field, String digest, String feed, String finsCount) {
        super(name, species, field, digest, feed);
        this.finsCount = finsCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", " + swim());
    }
    public String swim() {
        return finsCount;
    }
}
