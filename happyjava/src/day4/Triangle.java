package day4;

public class Triangle {
    public static void main(String[] args) {
        for(int j = 1; j <= 5; j++){
            for (int k = 6-j; k >= j; k--){
                System.out.println("*");
            }
            System.out.println();
        }
    }
}
