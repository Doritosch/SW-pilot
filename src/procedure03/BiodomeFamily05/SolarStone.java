package procedure03.BiodomeFamily05;

public class SolarStone extends AncientArtifact implements EnergyGenerator, Chargeable {
    private int amount;

    public SolarStone() {
        super("태양의 돌");
        this.amount = 0;
    }

    @Override
    public void describe() {
        System.out.println("태양의 돌로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.");
    }

    @Override
    public void generateEnergy() {
        System.out.println("태양의 돌을 이용해 에너지를 생성했습니다!");
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
