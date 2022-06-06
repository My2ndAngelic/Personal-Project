package aoc.AoC2021;

import java.util.ArrayList;
import java.util.Arrays;

public class AoC6 {
    public static ArrayList<Integer> spawn(ArrayList<Integer> dataIn, int maxDay) {
        ArrayList<Integer> dataOut = new ArrayList<>(dataIn);
        for (int i = 0; i < maxDay; i++) {
            int k = dataOut.size();
            for (int j = 0; j < k; j++) {
                if (dataOut.get(j) > 0) {
                    dataOut.set(j, dataOut.get(j) - 1);
                } else {
                    dataOut.set(j, 6);
                    dataOut.add(8);
                }
            }
        }
        return dataOut;
    }

    public static String spawn2(String dataIn, int maxDay) {
        StringBuilder dataOut = new StringBuilder(dataIn.replaceAll(",", ""));
        for (int i = 0; i < maxDay; i++) {
            int k = dataOut.length();
            for (int j = 0; j < k; j++) {
                if (Integer.parseInt(String.valueOf(dataOut.charAt(j))) > 0) {
                    dataOut.replace(j, j + 1, String.valueOf(Integer.parseInt(String.valueOf(dataOut.charAt(j))) - 1));
                } else {
                    dataOut.replace(j, j + 1, "6");
                    dataOut.append(8);
                }
            }
        }
        return dataOut.toString();
    }

    public static long problemOne(ArrayList<String> dataIn) {
//        return spawn(Arrays.stream(dataIn.get(0).split(",")).mapToInt(Integer::parseInt).collect(ArrayList::new, List::add, ArrayList::addAll),80).size();
        return spawn3(dataIn.get(0), 80);
    }

    // Copied from Java discord server
    public static long spawn3(String dataIn, int maxDay) {
        final int[] fish = Arrays.stream(dataIn.split(",")).mapToInt(Integer::parseInt).toArray();
        long[] fishTimer = new long[9];

        for (int f : fish) {
            fishTimer[f]++;
        }

        // Spawn the fish
        for (int i = 0; i < maxDay; i++) {
            long temp = fishTimer[0];
            System.arraycopy(fishTimer, 1, fishTimer, 0, fishTimer.length - 1);
            fishTimer[fishTimer.length - 1] = temp;
            fishTimer[6] += temp;
        }

        long totalFish = 0;
        for (long f : fishTimer) {
            totalFish += f;
        }
        return totalFish;
    }

    public static long problemTwo(ArrayList<String> dataIn) {
        return spawn3(dataIn.get(0), 256);
    }
}
