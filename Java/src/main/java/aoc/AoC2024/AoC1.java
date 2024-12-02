package aoc.AoC2024;

import aoc.AoCUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AoC1 {
    public static void main(String[] args) {
        String directory = String.format("%s/src/main/java/aoc/AoC2024/input/input1.txt", System. getProperty("user.dir"));
        try {
//            List<String> output = AoCUtilities.fileImportToStringArrayList(String.format("%s/src/main/java/aoc/AoC2024/input/input1.txt", System. getProperty("user.dir")));
            List<String> output = AoCUtils.fileImportToGeneric(directory, String::valueOf);
            List<List<Integer>> output2 = output.stream()
                    .map(s -> Arrays.stream(s.split("\\s+"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            System.out.println(output2);
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
