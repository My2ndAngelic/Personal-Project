package aoc.AoC2021;

import java.util.ArrayList;

public class AoC8 {
    public static int problemTwo(ArrayList<String> dataIn) {
        int count = 0;
        ArrayList<LeDisplay> ld = getDisplayOut(dataIn);
        for (int i = 0; i < ld.size() - 4; i++) {
            count += 1000 * ld.get(i).getNumber() + 100 * ld.get(i + 1).getNumber() + 10 * ld.get(i + 2).getNumber() + ld.get(i + 3).getNumber();
        }
        return count;
    }

    public static ArrayList<LeDisplay> getDisplayOut(ArrayList<String> dataIn) {
        ArrayList<LeDisplay> ld = new ArrayList<>();
        for (String i : dataIn) {
            String[] tempStringArray = stringSplit(i, 1);
            for (String j : tempStringArray) {
                if (j.chars().allMatch(Character::isLetter)) {
                    ld.add(new LeDisplay(j));
                }
            }
        }
        return ld;
    }

    public static String[] stringSplit(String in, int o) {
        return in.split("\\|")[o].split("\\s+");
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");
        a.add("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc");
        a.add("fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg");
        a.add("fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb");
        a.add("aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea");
        a.add("fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb");
        a.add("dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe");
        a.add("bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef");
        a.add("egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb");
        a.add("gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce");
        System.out.println(problemOne(a));
//        System.out.println(problemTwo(a));
        LeDisplay ld = new LeDisplay("cefbgd");
        System.out.println(ld.getNumber());
    }

    public static int problemOne(ArrayList<String> dataIn) {
        int count = 0;
        ArrayList<LeDisplay> ld = getDisplayOut(dataIn);
        for (LeDisplay ldc : ld) {
            switch (ldc.getLength()) {
                case 2, 3, 4, 7 -> count++;
            }
        }
        return count;
    }

    public static String[] stringSplit(String in) {
        return in.split("\\s+");
    }
}

class LeDisplay {
    private final String[] defaultMap = "abcdefg".chars().mapToObj(Character::toString).toArray(String[]::new);
    private String input;
    private String[] code;
    private String[] newMap;

    LeDisplay(String in) {
        if (in.chars().allMatch(Character::isAlphabetic)) {
            this.input = in.replaceAll("\\s+", "");
        }
    }


    LeDisplay(String in, String[] code) {
        if (in.chars().allMatch(Character::isAlphabetic)) {
            this.input = in.replaceAll("\\s+", "");
            this.code = code;
            this.newMap = theConnector(code);
        }
    }

    private String[] theConnector(String[] code) {
        return new String[1];
    }

    public String getInput() {
        return input;
    }

    public int getLength() {
        return input.length();
    }

    public void setWire(String input) {
        this.input = input;
    }

    public int getNumber() {
        String temp = "";
        return -1;
    }
}
