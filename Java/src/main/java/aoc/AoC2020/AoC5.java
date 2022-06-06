package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC5 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        try {
            al = fileReader(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input5.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int max = 0;
        for (String s : al) {
            int maxtemp = getSeatID(s.toCharArray());
            if (maxtemp >= max) {
                max = maxtemp;
            }
        }
        System.out.println(max);

        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            int a = getSeatID(al.get(i).toCharArray());
            for (int j = i + 1; j < al.size(); j++) {
                int b = getSeatID(al.get(j).toCharArray());
                if (Math.abs(a - b) == 2) {
                    al2.add((a + b) / 2);
                }
            }
        }
        ArrayList<Integer> alid = new ArrayList<>();
        for (String s : al) {
            alid.add(getSeatID(s.toCharArray()));
        }
        for (int i : al2) {
            boolean b = alid.contains(i);
            if (!b) {
                System.out.println(i);
            }
        }
    }

    public static ArrayList<String> fileReader(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner s = new Scanner(f);
        ArrayList<String> al = new ArrayList<>();
        while (s.hasNextLine()) {
            al.add(s.nextLine());
        }
        return al;
    }

    public static int getSeatID(char[] chars) {
        int a = getRow(chars);
        int b = getColumn(chars);
        return a * 8 + b;
    }

    public static int getRow(char[] chars) {
        int a = 0;
        int b = 127;
        for (int i = 0; i < 7; i++) {
            if (chars[i] == 'B') {
                a = (a + b + 1) / 2;
            } else if (chars[i] == 'F') {
                b = (a + b) / 2;
            }
        }
        if (a == b) {
            return a;
        } else {
            return -1;
        }
    }

    public static int getColumn(char[] chars) {
        int a = 0;
        int b = 7;

        for (int i = 7; i <= 9; i++) {
            if (chars[i] == 'R') {
                a = (a + b + 1) / 2;
            } else if (chars[i] == 'L') {
                b = (a + b) / 2;
            }
        }
        if (a == b) {
            return a;
        } else {
            return -1;
        }
    }
}
