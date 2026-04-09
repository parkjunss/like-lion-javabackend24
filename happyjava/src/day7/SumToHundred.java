package day7;

public class SumToHundred {
    int sum;
    int num;

    public SumToHundred(int num) {
        this.num = num;
    }

    public int getSum() {
        sum = 0;
        for (int i = 0; i < num; i++){
            sum += i+1;
        }
        return sum;
    }

    public void printSum() {
        this.getSum();
        System.out.printf("Sum 1 to %d = %d", num, sum);
    }
}
