package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonUsage {
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
