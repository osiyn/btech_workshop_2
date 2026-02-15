public class ImagingSatellite extends Satellite {
    
    private double resolution; // Разрешение получаемых со спутника фото
    private int photosTaken; // Счетчик полученных фото

    public ImagingSatellite(String name, double batteryLevel, double resolution)
    {
        this.name = name;
        this.isActive = false;
        this.batteryLevel = batteryLevel;
        this.resolution = resolution;
        this.photosTaken = 0;

        System.out.println(String.format("Создан спутник: %s (заряд: %.2f%%, разрешение: %.2f м/пиксель)", name, batteryLevel * 100, resolution));
    }

    // Если спутник включен, нужно сделать фото с помощью takePhoto, а также потратить 0.08 заряда
    @Override
    protected void performMission()
    {
        takePhoto();
        if(isActive) {
            consumeBattery(0.08);
        }
    }

    @Override
    public String toString() {
        return String.format("ImagingSatellite{resolution=%.2f, photosTaken=%d, name=%s, isActive=%b, batteryLevel=%.2f}",
                resolution,
                photosTaken,
                name,
                isActive,
                batteryLevel);
    }

    // Геттер для получения скрытого поля resolution
    public double getResolution()
    {
        return resolution;
    }

    // Геттер для получения скрытого поля photosTaken
    public int getPhotosTaken()
    {
        return photosTaken;
    }

    // Метод, который увеличивает счетчик фотографий, сделанных спутником, при условии, что спутник активен
    private void takePhoto()
    {
        if(isActive) {
            System.out.println(String.format("%s: Съемка территории с разрешением %.2f м/пиксель", name, resolution));
            photosTaken += 1;
            System.out.println(String.format("%s: Снимок %d сделан", name, photosTaken));
        } else {
            System.out.println(String.format("%s: Не может выполнить съёмку - не активен", name));
        }
    }
}
