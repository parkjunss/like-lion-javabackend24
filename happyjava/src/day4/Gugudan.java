package day4;

public class Gugudan {
    public static void main(String[] args) {
//        for (int i = 2; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                System.out.printf("%d * %d = %d\t", i, j, i * j);
//            }
//        }

        carami: for(int i = 1; i <= 9; i++){
            for(int j = 2; j <= 9; j++){
                System.out.printf("%d * %d = %d\t",j,i, i*j);
                if(j > 4){
                    break carami;
                }
            }
            System.out.println();
        }
    }
}
