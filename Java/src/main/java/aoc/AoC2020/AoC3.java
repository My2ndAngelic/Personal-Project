package aoc.AoC2020;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class AoC3 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        try {
            al = CommonUsage.fileReader(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(treeFinder(al, 3, 1));

        int[] tempout2 = {treeFinder(al, 1, 1),
                treeFinder(al, 3, 1),
                treeFinder(al, 5, 1),
                treeFinder(al, 7, 1),
                treeFinder(al, 1, 2)
        };
        System.out.println(Arrays.toString(tempout2));
        long a = 1;
        for (int i : tempout2) {
            a *= i;
        }
        System.out.println(a);
    }

    public static int treeFinder(ArrayList<String> al, int right, int down) {
        int tree = 0;
        for (int i = 0; i < al.size(); i += down) {
            int pos = (right * i) % al.get(i).length();
            char a = al.get(i).charAt(pos);
            if (a == '#') {
                tree++;
            }
        }
        return tree;
    }
}
