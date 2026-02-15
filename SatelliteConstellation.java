import java.util.List;
import java.util.ArrayList;

public class SatelliteConstellation {
    private String constellationName; // Наименование группировки
    private List<Satellite> satellites; // Список спутников, входящих в группировку

    public SatelliteConstellation(String constellationName)
    {
        this.constellationName = constellationName;
        satellites = new ArrayList<Satellite>();
        System.out.println(String.format("Создана спутниковая группировка: %s", constellationName));
    }

    // Метод для добавления спутника в группировку
    public void addSatellite(Satellite satellite)
    {
        satellites.add(satellite);
        System.out.println(String.format("%s добавлен в группировку %s", satellite.getName(), constellationName));
    }

    // Метод выполнения миссий для всех спутников группировки
    public void executeAllMissions()
    {
        for(Satellite sat : satellites) {
            sat.performMission();
        }
    }

    // Метод получения списка спутников
    public List<Satellite> getSatellites()
    {
        return satellites;
    }
}
