package day6;

public class Dice {
    private final int face;

    public Dice(int face) {
        this.face = face;
    }

    public int roll(){
        return (int) (Math.random() * this.face + 1);
    }

    public int multiRoll(int times, int targetNum){
        if (targetNum < 1 || targetNum > this.face) {
            throw new IllegalArgumentException("목표 숫자(" + targetNum + ")가 주사위 범위(1~" + this.face + ")를 벗어났습니다.");
        }
        int targetTimes = 0;
        for(int i = 0; i < times; i++){
            if(targetNum == this.roll()){
                targetTimes++;
            }
        }
        return targetTimes;
    }

    public static void main(String[] args) {
        int targetNum = 20;
        int times = 100;
        Dice dice = new Dice(20);

        System.out.println("Random : " + dice.roll());

        try {
            int targetTime = dice.multiRoll(times, targetNum);
            System.out.printf("Total times of %d: %d\n", targetNum, targetTime);
        } catch (IllegalArgumentException e) {
            // 3. 에러가 발생했을 때 처리할 내용
            System.err.println("[에러 발생] " + e.getMessage());
        }

    }
}
