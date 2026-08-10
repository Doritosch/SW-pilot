package procedure03.BiodomeFamily01;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    List<Organism> organismList;

    public LifeNest() {
        organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println(organism.name + "이(가) 추가되었습니다.");
    }
    public void removeOrganism(String name) {
        for(Organism organism : organismList) {
            if (organism.name.equals(name)) {
                organismList.remove(organism);
                System.out.println(name + "이(가) 삭제되었습니다.");
                return;
            }
        }
        System.out.println(name + "이(가) 리스트에 없습니다.");
    }
    public void displayList() {
        for(int i=1; i<=organismList.size(); i++) {
            Organism organism = organismList.get(i - 1);
            System.out.println(i + ". " + organism.name + ", " + organism.species + ", " + organism.field);
        }
    }
    public void searchOrganismByName(String name) {
        for(Organism organism : organismList) {
            if (organism.name.equals(name)) {
                System.out.println("[" + name + "] 검색결과: " + organism.name + ", " + organism.field + ", " + organism.species);
            }
        }
    }
}
