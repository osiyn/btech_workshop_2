public class EnergySystem {
    protected double batteryLevel; // Уровень заряда
    private static final double LOW_BATTERY_THRESHOLD = 0.2;
    private static final double MAX_BATTERY = 1.0;
    private static final double MIN_BATTERY = 0.0;

    public EnergySystem(double batteryLevel) {
        this.batteryLevel = Math.max(MIN_BATTERY, Math.min(MAX_BATTERY, batteryLevel));
    }

    //  Метод потребления энергии спутником при выполнении миссии
    public boolean consume(double consumeBatt) {
        if(consumeBatt <= 0 || batteryLevel <= MIN_BATTERY){
            return false;
        }
        batteryLevel = Math.max(MIN_BATTERY, batteryLevel - consumeBatt);
        return true;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public boolean hasSufficientPower() {
        return batteryLevel > LOW_BATTERY_THRESHOLD;
    }

    @Override
    public String toString() {
        return "EnergySystem{" +
                "batteryLevel=" + batteryLevel +
                '}';
    }
}
