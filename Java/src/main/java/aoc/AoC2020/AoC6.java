package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC6 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        try {
            al = fileReader(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input6.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        al.add("");

        // Part 1
        int counter = 0;
        ArrayList<String> al2 = new ArrayList<>();
        for (String s : al) {
            if (s.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                al2.forEach(sb::append);
                for (int j = 0; j < sb.length(); j++) {
                    int a = sb.indexOf(Character.toString(sb.charAt(j)));
                    int b = sb.lastIndexOf(Character.toString(sb.charAt(j)));
                    if (a != b) {
                        sb.deleteCharAt(a);
                        j--;
                    }
                }
                counter += sb.length();
                System.out.println(counter);
                al2 = new ArrayList<>();
            } else {
                al2.add(s);
            }
        }
        System.out.println(counter);
        System.out.println(al);
        // Part 2
        al2 = new ArrayList<>();
        counter = 0;
        for (String s : al) {
            if (s.isEmpty()) {
                for (int i = 0; i < 26; i++) {
                    int counter2 = 0;
                    String c = Character.toString((char) i + 97);
                    for (String sa : al2) {
                        if (sa.contains(c)) {
                            counter2++;
                        }
                    }
                    if (counter2 == al2.size()) {
                        counter++;
                    }
                }
                al2 = new ArrayList<>();
            } else {
                al2.add(s);
            }
        }
        System.out.println(al2);
        System.out.println(counter);
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
}
