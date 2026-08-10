package procedure03.BiodomeFamily03;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        Animal penguin = new Bird("펭귄", "동물", "남극", "육식", "물고기", "70cm");
        Animal koala = new Mammal("코알라", "동물", "호주", "초식", "유칼립투스", "예");
        Animal salmon = new Fish("연어", "동물", "바다", "육식", "플랑크톤", "8");
        Plant cactus = new Plant("선인장", "식물", "사막", "11월", "열매 있음");
        Plant peppermint = new Plant("페퍼민트", "식물", "정원", "7월", "열매 없음");

        LifeNest lifeNest = new LifeNest();
        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(salmon);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        lifeNest.displayAll();

        lifeNest.removeOrganism(koala);
        lifeNest.removeOrganism(peppermint);

        lifeNest.displayAll();
    }
}
