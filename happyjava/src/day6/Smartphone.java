package day6;

public class Smartphone {
    String brand;
    String model;
    int batteryLevel;

    public Smartphone(String brand, String model, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    public void checkBattery(){
        System.out.printf("현재 배터리 잔량은 [%d]%%입니다.\n", batteryLevel);
    }

    public void charge(){
        this.batteryLevel += 10;
        if  (this.batteryLevel >= 100){
            System.out.println("full charged");
        } else {
            System.out.println("충전 중... 배터리가 10% 증가했습니다.");
        }
    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone("Samsung", "Galaxy s24", 100);
        smartphone.checkBattery();
        smartphone.charge();
    }


}
