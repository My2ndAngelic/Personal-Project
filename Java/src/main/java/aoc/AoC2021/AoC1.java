package aoc.AoC2021;

import java.util.ArrayList;

public class AoC1 {
    public static int problemTwo(ArrayList<String> dataIn) {
        ArrayList<Integer> data = dataIn.stream().map(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        ArrayList<Integer> testArray = new ArrayList<>();
        for (int i = 0; i < data.size() - 2; i++) {
            testArray.add(data.get(i) + data.get(i + 1) + data.get(i + 2));
        }
        ArrayList<String> testArray1 = testArray.stream().map(e -> Integer.toString(e)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return problemOne(testArray1);
    }

    public static int problemOne(ArrayList<String> dataIn) {
        ArrayList<Integer> data = dataIn.stream().map(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        int temp = 0;
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i) < data.get(i + 1)) {
                temp++;
            }
        }
        return temp;
    }
}
