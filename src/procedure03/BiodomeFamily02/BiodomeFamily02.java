package procedure03.BiodomeFamily02;

public class BiodomeFamily02 {
    public static void main(String[] args) {
        Organism animal1 = new Organism("코끼리", "동물", "습지대", "지능이 높다", "60년");
        Organism animal2 = new Organism("펭귄", "동물", "남극", "귀엽다", "30년");
        Organism plant1 = new Organism("라일락", "식물", "온대 지역", "향기가 강하다", "100년");
        Organism plant2 = new Organism("페퍼민트", "식물", "정원", "향기롭다", "200년");

        LifeNest lifeNest = new LifeNest();
        lifeNest.addOrganism(animal1);
        lifeNest.addOrganism(animal2);
        lifeNest.addOrganism(plant1);
        lifeNest.addOrganism(plant2);

        lifeNest.displayList();

        lifeNest.removeOrganism(animal2);
        lifeNest.removeOrganism(plant1);

        animal1.setField("해변");

        lifeNest.displayList();

        animal1.setCharacteristic("코가 길다");

        lifeNest.displayList();
    }
}
