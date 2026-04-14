package day8;

public class Character {
    private Attackable attackStrategy;

    public void setAttackStrategy(Attackable strategy) {
        this.attackStrategy = strategy;
    }

    public void performAttack() {
        if (attackStrategy != null) {
            attackStrategy.attack();
        } else {
            System.out.println("공격 무기가 없습니다.");
        }
    }
}
