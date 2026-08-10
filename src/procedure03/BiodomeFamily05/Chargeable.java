package procedure03.BiodomeFamily05;

public interface Chargeable {
    int getAmount();
    void setAmount(int amount);

    default void charge(int amount) {
        setAmount(getAmount() + amount);
        System.out.println(getName() + "에 " + amount + "만큼 에너지를 충전합니다.");
    }

    default void getChargeLevel() {
        System.out.println(getName() + "에 총 " + getAmount() + "만큼의 에너지가 충전되었습니다.");
    }

    String getName();

    static void showChargingTips() {
        System.out.println("에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야합니다.");
    }
}
