package aoc.AoC2021;

import java.util.ArrayList;

public class AoC2 {
    public static int problemOne(ArrayList<String> dataIn) {
        int horizontal = 0;
        int vertical = 0;
        for (String s : dataIn) {
            String[] ss = s.split(" ");
            Movement inS = Movement.valueOf(ss[0]);
            switch (inS) {
                case forward -> horizontal += Integer.parseInt(ss[1]);
                case down -> vertical += Integer.parseInt(ss[1]);
                case up -> vertical -= Integer.parseInt(ss[1]);
                default -> System.out.println("fu");
            }
        }
        return horizontal * vertical;
    }

    public static int problemTwo(ArrayList<String> dataIn) {
        int horizontal = 0;
        int vertical = 0;
        int aim = 0;
        for (String s : dataIn) {
            String[] ss = s.split(" ");
            Movement inS = Movement.valueOf(ss[0]);
            switch (inS) {
                case forward -> {
                    horizontal += Integer.parseInt(ss[1]);
                    vertical += aim * Integer.parseInt(ss[1]);
                }
                case down -> aim += Integer.parseInt(ss[1]);
                case up -> aim -= Integer.parseInt(ss[1]);
                default -> System.out.println("fu");
            }
        }
        return horizontal * vertical;
    }

    enum Movement {forward, down, up}
}
