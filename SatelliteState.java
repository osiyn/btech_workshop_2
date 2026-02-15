public class SatelliteState {
    private boolean isActive = false;
    private String statusMessage;

    public SatelliteState() {
        this.statusMessage = "Не активирован";
    }

    public boolean activate(boolean hasSufficientPower) {
        if(hasSufficientPower && !isActive) {
            isActive = true;
            statusMessage = "Активен";
            return true;
        }
        statusMessage = hasSufficientPower ? "Уже активене" : "Недостаточно энергии";
        return false;
    }

    public void deactivate() {
        isActive = false;
        statusMessage = "Деактивирован";
    }

    public String getStatus() {
        return statusMessage;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "SatelliteState{" +
            "isActive=" + isActive +
            ", statusMessage='" + statusMessage + '\'' +
            '}';

    }
}
