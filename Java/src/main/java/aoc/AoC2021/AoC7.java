package aoc.AoC2021;

import java.util.ArrayList;
import java.util.Arrays;

public class AoC7 {
    public static int problemOne(ArrayList<String> dataIn) {
        return fuelCount1b(dataIn.get(0));
    }

    // Courtesy: https://github.com/sumsar1812/AOC2021/tree/master/Day6
    public static int fuelCount1b(String dataIn) {
        int[] fuelArray = Arrays.stream(dataIn.split(",")).mapToInt(Integer::parseInt).toArray();
        int average = (int) Arrays.stream(fuelArray).average().orElse(0); // taking average
        int avgConsumption = helperMethod(fuelArray, average); // taking fuel consumption

        // Finding the way up or down
        int add = 1;
        int temp0 = helperMethod(fuelArray, average + 1);
        if (temp0 > avgConsumption) {
            add = -1;
        }

        // Keep going up/down until hitting the bigger
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int pos = average + add * i;
            int temp = helperMethod(fuelArray, pos);
            if (temp < avgConsumption) {
                average = pos;
                avgConsumption = temp;
                i--;
            } else {
                break;
            }
        }
        return avgConsumption;
    }

    public static int helperMethod(int[] list, int pos) {
        int temp = 0;
        for (int j : list) {
            temp += Math.abs(j - pos);
        }
        return temp;
    }

    public static int problemTwo(ArrayList<String> dataIn) {
        return fuelCount2a(dataIn.get(0));
    }

    public static int fuelCount2a(String dataIn) {
        int[] fuelArray = Arrays.stream(dataIn.split(",")).mapToInt(Integer::parseInt).toArray();
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < fuelArray.length; i++) {
            int temp = 0;
            for (int j = 0; j < fuelArray.length; j++) {
                if (fuelArray[j] != i) {
                    int diff = Math.abs(fuelArray[j] - i);
                    temp += (diff) * (diff + 1) / 2;
                    if (temp >= smallest) {
                        break;
                    }
                }
            }
            if (temp < smallest) {
                smallest = temp;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        String test = "16,1,2,0,4,2,7,1,2,14";
        System.out.println(fuelCount1a(test));
        System.out.println(fuelCount1b(test));
        System.out.println(fuelCount2a(test));
    }

    public static int fuelCount1a(String dataIn) {
        int[] fuelArray = Arrays.stream(dataIn.split(",")).mapToInt(Integer::parseInt).toArray();
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < fuelArray.length; i++) {
            int temp = 0;
            for (int j = 0; j < fuelArray.length; j++) {
                temp += Math.abs(fuelArray[j] - i);
                if (temp >= smallest) {
                    break;
                }
            }
            if (temp < smallest) {
                smallest = temp;
            }
        }
        return smallest;
    }
}
