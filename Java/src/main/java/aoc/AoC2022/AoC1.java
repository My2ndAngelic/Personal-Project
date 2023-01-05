package aoc.AoC2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AoC1 {
    private static ArrayList<Integer> summedList(String dataIn) {
        ArrayList<String> ali = new ArrayList<>(Arrays.stream(dataIn.split("\n\n")).toList());
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
        return ali3;
    }

    public static long problemOne(String dataIn) {
        ArrayList<Integer> leSum = summedList(dataIn);

        Integer max = leSum.stream().sorted(Comparator.reverseOrder()).toList().get(0);

//        int max = leSum.get(0);
//        for (int x : leSum) {
//            if (x > max) {
//                max = x;
//            }
//        }

        return max;
    }

    public static long problemTwo(String dataIn) {
        ArrayList<Integer> leSum = summedList(dataIn);

        List<Integer> leSortedList = leSum.stream().sorted(Comparator.reverseOrder()).toList();

        return leSortedList.get(0) + leSortedList.get(1) + leSortedList.get(2);
    }
}
