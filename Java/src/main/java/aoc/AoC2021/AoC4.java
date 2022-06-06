package aoc.AoC2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AoC4 {
    public static int problemOne(ArrayList<String> input) {
        ArrayList<Integer> number = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Board> boardArrayList = new ArrayList<>();
        Board temp = new Board(5, 5);

        for (int i = 2; i < input.size(); i++) {
            String dataFromInput = input.get(i);
            if (dataFromInput.isEmpty()) { // If empty line, add board and empty it
                boardArrayList.add(temp);
                temp = new Board(5, 5);
            } else { // Copy all the array to each line of the board
                String[] a = dataFromInput.split("\\s+");
                String[] b = new String[5];
                if (a[0].isEmpty()) {
                    System.arraycopy(a, 1, b, 0, a.length - 1);
                } else {
                    System.arraycopy(a, 0, b, 0, a.length);
                }
                int[] line = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < 5; j++) {
                    if (Arrays.equals(temp.getLine(j), new int[]{0, 0, 0, 0, 0})) { // Copy the line to the nearest empty line of the board
                        temp.setLine(line, j);
                        break;
                    }
                }
            }


        }

//        for (Board b : boardArrayList) {
//            System.out.println(Arrays.deepToString(b.getBoard()));
//        }
        return -1;
    }

    public static int problemTwo(ArrayList<String> input) {
        return -1;
    }
}

class Board {
    private int[][] data;
    private int[] marked;

    Board(int[][] input) {
        this.data = input;
    }

    Board() {
    }

    Board(int x, int y) {
        this.data = new int[x][y];
    }

    public int getPos(int x, int y) {
        return this.data[x - 1][y - 1];
    }

    public void setData(int[][] input) {
        this.data = input;
    }

    public void setLine(int[] line, int pos) {
        data[pos] = line;
    }

    public int[] getLine(int pos) {
        return data[pos];
    }

    public int[][] getBoard() {
        return data;
    }

//    public void reset() {
//        for (int i = 0; i < data.length; i++){
//            for (int j = 0; j < data[0].length; j++) {
//                data[i][j] = 0;
//            }
//        }
//    }
}