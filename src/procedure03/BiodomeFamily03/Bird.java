package procedure03.BiodomeFamily03;

public class Bird extends Animal {
    private String wingSpan;

    public Bird(String name, String species, String field, String digest, String feed, String wingSpan) {
        super(name, species, field, digest, feed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", " + fly());
    }
    public String fly() {
        return wingSpan;
    }
}
