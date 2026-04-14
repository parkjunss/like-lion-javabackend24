package day8;

abstract class Transport {
    int capacity;
    Transport(int capacity){
        this.capacity = capacity;
    }

    abstract void move();
    void showCapacity(){
        System.out.printf("최대 %d명까지 탑승 가능합니다.\n", capacity);
    }
}

class Bus extends Transport {
    Bus(int capacity) {
        super(capacity);
    }

    @Override
    void move() {
        System.out.println("버스가 도로를 따라 이동합니다.");
    }

}

class Airplane extends Transport {
    Airplane(int capacity) {
        super(capacity);
    }

    @Override
    void move(){
        System.out.println("비행기가 하늘을 날아 이동합니다.");
    }
}
