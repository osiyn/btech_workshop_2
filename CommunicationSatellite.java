public class CommunicationSatellite extends Satellite {
    
    private double bandWith;

    public CommunicationSatellite(String name, double batteryLevel, double bandWidth)
    {
        super(name, batteryLevel);
        this.bandWith = bandWidth;

        System.out.println(String.format("Создан спутник: %s (заряд: %.2f%%, скорость передачи: %.2f Мбит/c)", name, batteryLevel * 100, bandWidth));
    }

    // Если спутник включен, нужно отправить данные с помощью sendData, а также потратить 0.05 заряда
    @Override
    protected void performMission()
    {
        if(state.isActive()) {
            sendData(bandWith);
            energy.consume(0.05);
        }
    }

    @Override
    public String toString() {
        return String.format("CommunicationSatellite{bandwidth=%.2f, name=%s, isActive=%b, batteryLevel=%.2f}",
                bandWith,
                name,
                state.isActive(),
                energy.getBatteryLevel());
    }

    // Геттер для получения скрытого поля bandWidth
    public double getBandwith()
    {
        return bandWith;
    }

    // Метод, который выводит в консоль информацию о количестве переданных данных (срабатывает, если спутник активен)
    private void sendData(double sendData)
    {
        if(state.isActive()) {
            System.out.println(String.format("%s: Передача данных со скоростью %.2f Мбит/с", name, bandWith));
            System.out.println(String.format("%s: Отправил %.2f Мбит данных!", name, sendData));
        } else {
            System.out.println(String.format("%s: Не может отправить данные - не активен", name));
        }
    }

}
