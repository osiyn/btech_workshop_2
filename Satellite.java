abstract class Satellite
{
    protected String name; // Название
    protected boolean isActive; // Флаг активности
    protected double batteryLevel; // Уровень заряда

    public Satellite()
    {
        this.name = "Undefine";
        this.isActive = false;
        this.batteryLevel = 1.0;
    }

    public Satellite(String name, double batteryLevel)
    {
        this.name = name;
        this.isActive = false;
        this.batteryLevel = batteryLevel;
    }
    
    // Метод включения спутника (спутник включается, если уровень заряда больше 0.2)
    public boolean activate() {
        if(batteryLevel > 0.2) {
            isActive = true;
            System.out.println(String.format("%s: Активация успешна", name));
            return true;
        } else {
            System.out.println(String.format("%s: Ощибка активации (заряд %.2f%%)", name, batteryLevel * 100));
            return false;
        }
    }

    // Метод выключения спутника (только если он был включен)
    public void deactivate() {
        if(isActive) {
            isActive = false;
        }
    }

    //  Метод потребления энергии спутником при выполнении миссии
    public void consumeBattery(double consumeBatt) {
        batteryLevel -= consumeBatt;
        if(batteryLevel <= 0.2) {
            deactivate();
        }
    }

    // Метод выполнения миссии
    abstract protected void performMission();

    public String getName()
    {
        return name;
    }
}