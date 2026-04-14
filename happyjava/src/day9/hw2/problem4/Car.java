package day9.hw2.problem4;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double maxFuel; // 최대 연료 용량
    private double fuel;    // 현재 연료량
    private Engine engine;
    private Drive driveSystem; // Drive 인스턴스 생성 필요
    private final int kiloPerLiters = 10;

    private class Engine {
        private boolean isOn = false;

        // 엔진 시동
        void startEngine() {
            isOn = true;
            System.out.println("Engine is started");
        }

        // 엔진 종료
        void stopEngine() {
            isOn = false;
            System.out.println("Engine is stopped");
        }
    }

    private class Drive {
        // 운전 메소드 엔진 시동 여부, 필요한 연료계산 주행 후 모자라면 모자란 거리 출력
        public void drive(double distance) {
            if (!engine.isOn) {
                System.out.println("Engine is stopped. Cannot drive.");
                return;
            }
            double requiredFuel = distance / kiloPerLiters;

            if (fuel >= requiredFuel) {
                fuel -= requiredFuel;
                System.out.println("Car is driving " + distance + "km");
            } else {
                double canDistance = fuel * kiloPerLiters;
                if (canDistance > 0) {
                    System.out.println("Car is driving " + canDistance + "km (Stop: Out of fuel)");
                    fuel = 0;
                }
                System.out.println("Not enough fuel to drive " + (distance - canDistance) + "km more.");
            }
        }
        // 주유 넘치는 주유량 출력
        public void refuel(double amount) {
            if (fuel + amount <= maxFuel) {
                fuel += amount;
                System.out.println("Car is refueling: " + amount + "L");
            } else {
                double canFill = maxFuel - fuel;
                double overflow = amount - canFill;
                fuel = maxFuel;
                System.out.println("Full tank! " + overflow + "L overflowed.");
            }
        }

        // 주행 가능 여부 엔진 확인 연료 연비 가능한 거리 확인
        public void canDrive(double distance) {
            if (!Car.this.engine.isOn) {
                System.out.println("Engine is stopped. Cannot drive.");
                return;
            }

            double range = Car.this.fuel * kiloPerLiters;

            if (range >= distance) {
                System.out.printf("Can drive for %f.\n", range);
            } else {
                double lack = distance - range;
                System.out.printf("Cannot drive: Fuel is not enough. %.1fL short. (lack distance: %.1fkm)\n", lack / kiloPerLiters, lack);
            }
        }
    }

    // 생성자
    public Car(String brand, String model, int year, double maxFuel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.maxFuel = maxFuel;
        this.fuel = maxFuel / 2;
        this.engine = new Engine();
        this.driveSystem = new Drive();
    }

    // 외부에서 접근 가능한 메서드
    public void startEngine() { engine.startEngine(); }
    public void stopEngine() { engine.stopEngine(); }
    public void drive(double distance) { driveSystem.drive(distance); }
    public void canDrive(double distance) { driveSystem.canDrive(distance); }
    public void refuel(double amount) { driveSystem.refuel(amount); }

    // 차 정보 출력
    public void showCarStatus() {
        System.out.println("--- Status ---");
        System.out.println("Brand: " + brand + " | Model: " + model + " | Year: " + year);
        System.out.println("Fuel: " + fuel + " / " + maxFuel);
        System.out.println("Engine: " + (engine.isOn ? "ON" : "OFF"));
    }
}