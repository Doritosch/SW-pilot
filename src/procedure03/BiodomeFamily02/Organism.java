package procedure03.BiodomeFamily02;

public class Organism {
    private String name;
    private String species;
    private String field;
    private String characteristic;
    private String lifeSpan;

    public Organism(String name, String species, String field, String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.field = field;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
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
    public String getCharacteristic() {
        return this.characteristic;
    }
    public String getLifeSpan() {
         return this.lifeSpan;
    }
    public void setField(String field) {
        this.field = field;
        System.out.println(this.name + " 서식지가 변경되었습니다.");
    }
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
        System.out.println(this.name + " 특징이 변경되었습니다.");
    }
    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
        System.out.println(this.name + " 수명이 변경되었습니다.");
    }
}
