package procedure03.BiodomeFamily05;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer sorcerer = new Sorcerer("아리엘");
        SolarStone solarStone = new SolarStone();
        WindAmulet windAmulet = new WindAmulet();
        WaterMirror waterMirror = new WaterMirror();

        sorcerer.addAncientArtifact(solarStone);
        sorcerer.addAncientArtifact(windAmulet);
        sorcerer.addAncientArtifact(waterMirror);

        sorcerer.checkAncientArtifact(solarStone);

        sorcerer.useEnergyGenerator(waterMirror);

        solarStone.charge(50);
        waterMirror.charge(30);
        solarStone.charge(10);

        solarStone.getChargeLevel();
        waterMirror.getChargeLevel();

        Chargeable.showChargingTips();
    }
}
