package aoc.AoC2022;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class AoCMain {
    @SneakyThrows
    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);
//        System.out.print("Enter the path to folder: ");
//        String folder = userInput.nextLine();
//        userInput.close();
        String folder = "C:\\Users\\My2ndAngelic\\Documents\\GitHub\\Personal-Project\\Java\\src\\main\\java\\aoc\\AoC2022\\input";

        int minDay = 1;
        int maxDay = 1;

        for (int i = minDay; i <= maxDay; i++) {
            Class<?> c = Class.forName("aoc.AoC2022.AoC" + i);
            String input = AoCUtilities.fileImportToString(folder + "/input" + i + ".txt");
            Method m1 = c.getDeclaredMethod("problemOne", String.class);
            Method m2 = c.getDeclaredMethod("problemTwo", String.class);
            Object m1res = m1.invoke(String.class, input);
            System.out.print("Day " + i + ": " + m1res + " | ");
            Object m2res = m2.invoke(String.class, input);
            System.out.println(m2res);
        }
    }
}
