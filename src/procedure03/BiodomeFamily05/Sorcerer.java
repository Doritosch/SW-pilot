package procedure03.BiodomeFamily05;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer {
    private String name;
    private List<AncientArtifact> ancientArtifactList;

    public Sorcerer(String name) {
        this.name = name;
        ancientArtifactList = new ArrayList<>();
        System.out.println("마법사 '" + getName() + "'이(가) 생성되었습니다.");
    }

    public String getName() {
        return this.name;
    }
    public void addAncientArtifact(AncientArtifact ancientArtifact) {
        ancientArtifactList.add(ancientArtifact);
        System.out.println("마법사 '" + getName() + "'이 " + ancientArtifact.getName() + "을 소유하게 되었습니다.");
    }
    public void checkAncientArtifact(AncientArtifact ancientArtifact) {
        System.out.println("마법사 '" + getName() + "'이 " + ancientArtifact.getName() + "의 능력을 확인합니다.");
        ancientArtifact.describe();
    }
    public void useEnergyGenerator(EnergyGenerator energyGenerator) {
        energyGenerator.generateEnergy();
    }

    public void useWeatherController(WeatherController weatherController) {
        weatherController.controlWeather();
    }
}
