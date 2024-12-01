package aoc.AoC2024;

import aoc.AoCUtilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AoC1 {
    public static void main(String[] args) {
        try {
            List<String> output = AoCUtilities.fileImportToStringArrayList(String.format("%s/src/main/java/aoc/Aoc2024/input/input1.txt", System. getProperty("user.dir")));
            List<String[]> output2 = output.forEach(a -> {
                Arrays.stream(a.split(" "));
            });
            System.out.println(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * Two array list
         * Sort
         * Subtract distance
         * Should I save those distance? Perhaps YES
         */
    }
}
