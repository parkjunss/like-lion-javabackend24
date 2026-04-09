package day7;

import java.util.Arrays;
import java.util.Scanner;

public class FindFruit {
    private final String[] fruits = {"사과", "바나나", "딸기", "포도"};

    public void findFruit(Scanner input) {
        while (true) {
            System.out.println("Enter fruit name in Korean:");
            String fruit = input.nextLine();
            if(Arrays.asList(fruits).contains(fruit)){
                System.out.println("You Found " + fruit);
                break;
            } else {
                System.out.println("You Don't Have Such Fruit");
            }
        }
    }

}
