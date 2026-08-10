package procedure03.BiodomeFamily05;

public abstract class AncientArtifact {
    private String name;

    public AncientArtifact(String name) {
        this.name = name;
        System.out.println(name +" 유물이 생성되었습니다.");
    }
    public abstract void describe();

    public String getName() {
        return this.name;
    }
}
