package aoc.AoC2022;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class AoC1 {
    public static void main(String[] args) throws IOException {
        String temp0 = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000";

        String temp = AoCUtilities.fileImportToString(Path.of(System.getProperty("user.dir"),"/src/main/java/aoc/AoC2022/input/input1.txt").toString());

        ArrayList<String> ali = new ArrayList<>(Arrays.stream(temp.split("\n\n")).toList());
        ArrayList<String[]> ali2 = new ArrayList<>();
        for (String s : ali) {
            ali2.add(s.split("\n"));
        }
        ArrayList<Integer> ali3 = new ArrayList<>();
        for (String[] s : ali2) {
            int counter = 0;
            for (String ss : s) {
                counter += Integer.parseInt(ss);
            }
            ali3.add(counter);
        }

        System.out.println(ali3);
    }
}
