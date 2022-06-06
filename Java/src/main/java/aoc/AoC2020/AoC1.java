package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class AoC1 {
    public static void main(String[] args) {
        int a1 = 0;
        int a2 = 0;
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        List<Integer> al = new ArrayList<>();
        // Copied from
        try {
            File myObj = new File(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input4.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                al.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int[] theArray = al.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < theArray.length; i++) {
            for (int j = i + 1; j < theArray.length; j++) {
                for (int k = j + 1; k < theArray.length; k++) {
                    int c1 = theArray[i] + theArray[j];
                    if (c1 == 2020) {
                        a1 = theArray[i];
                        a2 = theArray[j];
                    }
                    int c2 = (theArray[i] + theArray[j] + theArray[k]);
                    if (c2 == 2020) {
                        b1 = theArray[i];
                        b2 = theArray[j];
                        b3 = theArray[k];
                    }
                }
            }
        }
        int[] out = {a1, a2};
        int[] out2 = {b1, b2, b3};
        System.out.println("Output: " + Arrays.toString(out) + " | " + (out[0] * out[1]));
        System.out.println("Output: " + Arrays.toString(out2) + " | " + (out2[0] * out2[1] * out2[2]));

        System.gc();
        // **** //
        // Part 3
        long time1 = System.nanoTime();
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        List<Integer> al2 = new ArrayList<>();
        try {
            File myObj = new File("/Users/my2ndangelic/Desktop/part3numbers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                al2.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Collections.sort(al2);
        int[] theArray2 = al2.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < theArray2.length; i++) {
            if (theArray2[i] > 3232322) {
                break;
            }
            for (int j = i + 1; j < theArray2.length; j++) {
                if (theArray2[j] > 3232322) {
                    break;
                }
                for (int k = j + 1; k < theArray2.length; k++) {
                    if (theArray2[k] > 3232322) {
                        break;
                    }
                    int e2 = (theArray2[i] + theArray2[j] + theArray2[k]);
                    if (e2 == 3232322) {
                        d1 = theArray2[i];
                        d2 = theArray2[j];
                        d3 = theArray2[k];
                    }
                    System.out.print(i + " " + " " + j + " " + k + " " + e2 + "\r");
                }
            }
        }
        long time2 = System.nanoTime();
        int[] out3 = {d1, d2, d3};
        double time = (double) (time2 - time1) / Math.pow(10, 9);
        BigInteger bi = BigInteger.valueOf(d1).multiply(BigInteger.valueOf(d2)).multiply(BigInteger.valueOf(d3));
        System.out.println("Output: " + Arrays.toString(out3) + " | " + bi);
        System.out.println("Elapsed: " + time);
    }
}
