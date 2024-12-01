package aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AoCUtilities {
    public static ArrayList<String> fileImportToStringArrayList(String path) throws IOException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        ArrayList<String> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(sc.nextLine());
        }
        return myData;
    }

    public static String[] fileImportToStringArray(String path) throws IOException {
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

    public static ArrayList<Integer> fileImportToIntegerArrayList(String path) throws IOException, NumberFormatException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        ArrayList<Integer> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(Integer.parseInt(sc.nextLine()));
        }
        return myData;
    }

    public static int[] fileImportToIntArray(String path) throws IOException, NumberFormatException {
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

    public static List<String> fileImportToListString(String path) throws IOException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<String> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(sc.nextLine());
        }
        return myData;
    }

    public static List<Integer> fileImportToListInteger(String path) throws IOException, NumberFormatException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<Integer> myData = new ArrayList<>();
        while (sc.hasNextLine()) {
            myData.add(Integer.parseInt(sc.nextLine()));
        }
        return myData;
    }

    public static String fileImportToString(String path) throws IOException {
        FileReader myFile = new FileReader(path);
        BufferedReader br = new BufferedReader(myFile);
        return br.lines().collect(Collectors.joining("\n"));
    }
}
