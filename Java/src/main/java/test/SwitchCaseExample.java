package test;

import java.util.ArrayList;
import java.util.List;

public class SwitchCaseExample {
    public static void main(String[] args) {
        int month = 9;
        switch (month) {
            case 12, 1, 2 -> System.out.println("Winter");
            case 3, 4, 5 -> System.out.println("Spring");
            case 6, 7, 8 -> System.out.println("Summer");
            case 9, 10, 11 -> System.out.println("Autumn");
            default -> System.out.println("Invalid month");
        }

        ArrayList<Integer> test = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        System.out.println(test);
    }
}
