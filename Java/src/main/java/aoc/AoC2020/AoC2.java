package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC2 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        try {
            File myObj = new File(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input4.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                al.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        List<Integer> s11 = new ArrayList<>();
        List<Integer> s12 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = new ArrayList<>();


        for (String s : al) {
            String[] t1 = s.split(" ");
            String[] t11 = t1[0].split("-");
            s11.add(Integer.valueOf(t11[0]));
            s12.add(Integer.valueOf(t11[1]));
            s2.add(t1[1].split(":")[0]);
            s3.add(t1[2]);
        }

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < s11.size(); i++) {
            if (passwordTest(s11.get(i), s12.get(i), s2.get(i), s3.get(i))) {
                count++;
            }
            if (passwordTest2(s11.get(i), s12.get(i), s2.get(i), s3.get(i))) {
                count2++;
            }
        }
        System.out.println(count);
        System.out.println(count2);
    }

    public static boolean passwordTest(int min, int max, String req, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == req.charAt(0)) {
                count++;
            }
        }
        return count >= min && count <= max;
    }

    public static boolean passwordTest2(int min, int max, String req, String s) {
        String a = String.valueOf(s.charAt(min - 1));
        String b = String.valueOf(s.charAt(max - 1));
        return a.equals(req) ^ b.equals(req);
    }
}
