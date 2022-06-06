package aoc.AoC2021;

import java.util.ArrayList;

public class AoC2Alt {
    private final ArrayList<String> data;
    private int horizontal;
    private int vertical;
    private int aim;

    AoC2Alt(ArrayList<String> dataIn) {
        this.horizontal = 0;
        this.vertical = 0;
        this.aim = 0;
        this.data = dataIn;
    }


    public int getPos() {
        return horizontal * vertical;
    }

    public void changePos1(String move, int value) {
        switch (move) {
            case "forward" -> horizontal += value;
            case "down" -> vertical += value;
            case "up" -> vertical -= value;
            default -> System.out.println("Not yet implemented.");
        }
    }

    public void changePos2(String move, int value) {
        switch (move) {
            case "forward" -> {
                horizontal += value;
                vertical += aim * value;
            }
            case "down" -> aim += value;
            case "up" -> aim -= value;
            default -> System.out.println("Not yet implemented.");
        }
    }

    public ArrayList<String> getData() {
        return data;
    }
}
