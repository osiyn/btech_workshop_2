public class Main {
    public static void main(String[] args)
    {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("============================================================");
        System.out.println("СОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("---------------------------------------------");

        CommunicationSatellite com1 = new CommunicationSatellite("Связь-1", 0.85, 500);
        CommunicationSatellite com2 = new CommunicationSatellite("Связь-2", 0.75, 1000);
        CommunicationSatellite com3 = new CommunicationSatellite("Связь-3", 0.15, 1000);
        ImagingSatellite pic1 = new ImagingSatellite("ДЗЗ-1", 0.92, 2.5);
        ImagingSatellite pic2 = new ImagingSatellite("ДЗЗ-2", 0.45, 1.0);
        ImagingSatellite pic3 = new ImagingSatellite("ДЗЗ-3", 0.15, 1.5);

        System.out.println("---------------------------------------------");

        SatelliteConstellation satCon = new SatelliteConstellation("RU Basic");

        System.out.println("---------------------------------------------");

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");

        satCon.addSatellite(com1);
        satCon.addSatellite(com2);
        satCon.addSatellite(com3);
        satCon.addSatellite(pic1);
        satCon.addSatellite(pic2);
        satCon.addSatellite(pic3);

        System.out.println("---------------------------------------------");

        for(Satellite satellite : satCon.getSatellites()) {
            System.out.print(satellite.toString());
            System.out.print(" | ");
        }

        System.out.println();

        System.out.println("---------------------------------------------");

        System.out.println("АКТИВАЦИЯ СПУТНИКОВ:");

        System.out.println("---------------------------------------------");

        for(Satellite satellite : satCon.getSatellites()) {
            satellite.activate();
        }

        System.out.println("---------------------------------------------");

        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ:");

        for(Satellite satellite : satCon.getSatellites()) {
            satellite.performMission();
        }

        System.out.println("---------------------------------------------");

        for(Satellite satellite : satCon.getSatellites()) {
            System.out.print(satellite.toString());
            System.out.print(" | ");
        }

        System.out.println();
    }
}
