package procedure03.BiodomeFamily02;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    private List<Organism> organismList;

    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println(organism.getName() + "이(가) 추가되었습니다.");
    }
    public void removeOrganism(Organism organism) {
        organismList.remove(organism);
        System.out.println(organism.getName() + "이(가) 삭제되었습니다.");
    }
    public void displayList() {
        System.out.println("전체 동식물 목록 출력:");
        for (int i=1; i<=organismList.size(); i++) {
            Organism organism = organismList.get(i - 1);
            System.out.println(i + ". " + organism.getName() + ", " + organism.getSpecies() + ", " + organism.getField() +
                    ", " + organism.getCharacteristic() + ", " + organism.getLifeSpan());
        }
    }
}
