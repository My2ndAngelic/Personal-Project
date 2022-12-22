package aoc.AoC2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoCUtilities {
    public static ArrayList<String> fileImportToStringArrayList(String path) throws FileNotFoundException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        ArrayList<String> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(sc.nextLine());
        }
        return myData;
    }

    public static String[] fileImportToStringArray(String path) throws FileNotFoundException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        String[] myData = new String[Math.toIntExact(myFile.length())];
        int i = 0;
        while (sc.hasNextLine()) {
            myData[i] = sc.nextLine();
            i++;
        }
        return myData;
    }

    public static ArrayList<Integer> fileImportToIntegerArrayList(String path) throws FileNotFoundException, NumberFormatException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        ArrayList<Integer> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(Integer.parseInt(sc.nextLine()));
        }
        return myData;
    }

    public static int[] fileImportToIntArray(String path) throws FileNotFoundException, NumberFormatException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        int[] myData = new int[Math.toIntExact(myFile.length())];
        int i = 0;
        while (sc.hasNextLine()) {
            myData[i] = Integer.parseInt(sc.nextLine());
            i++;
        }
        return myData;
    }

    public static List<String> fileImportToListString(String path) throws FileNotFoundException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<String> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(sc.nextLine());
        }
        return myData;
    }

    public static List<Integer> fileImportToListInteger(String path) throws FileNotFoundException, NumberFormatException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<Integer> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(Integer.parseInt(sc.nextLine()));
        }
        return myData;
    }

    public static String fileImportToString(String path) throws IOException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        StringBuilder myData = new StringBuilder();
        while (sc.hasNextLine()) {
            myData.append(sc.nextLine());
            myData.append("\n");
        }
        return myData.toString();
    }
}
