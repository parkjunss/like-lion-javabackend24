package day8;

public interface Attackable {
    void attack();
}

class SwordAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("칼로 공격합니다!");
    }

}

class BowAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("활로 공격합니다!");
    }
}

