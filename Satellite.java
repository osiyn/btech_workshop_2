public abstract class Satellite
{
    protected String name; // Название
    protected SatelliteState state; // Флаг активности
    protected EnergySystem energy;

    public Satellite(String name, double batteryLevel)
    {
        this.name = name;
        this.state = new SatelliteState();
        this.energy = new EnergySystem(batteryLevel);
    }

    public SatelliteState getState() {
        return state;
    }

    public EnergySystem getEnergy() {
        return energy;
    }
    
    // Метод включения спутника (спутник включается, если уровень заряда больше 0.2)
    public boolean activate() {
        if(state.activate(energy.hasSufficientPower())) {
            System.out.println(String.format("%s: Активация успешна", name));
            return true;
        } else {
            System.out.println(String.format("%s: Ощибка активации (заряд %.2f%%)", name, energy.getBatteryLevel() * 100));
            return false;
        }
    }

    // Метод выключения спутника (только если он был включен)
    public void deactivate() {
        if(state.isActive()) {
            state.deactivate();
            System.out.println(String.format("%s: Деактивирован", name));
        }
    }

    // Метод выполнения миссии
    abstract public void performMission();

    public String getName()
    {
        return name;
    }
}