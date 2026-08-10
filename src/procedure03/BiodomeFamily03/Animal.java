package procedure03.BiodomeFamily03;

public class Animal extends Organism {
    private String digest;
    private String feed;

    public Animal(String name, String species, String field, String digest, String feed) {
        super(name, species, field);
        this.digest = digest;
        this.feed = feed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print(", " + getDigest() + ", " + getFeed());
    }

    public String getDigest() {
        return this.digest;
    }
    public String getFeed() {
        return this.feed;
    }
}
