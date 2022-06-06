package aoc.AoC2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC4 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        try {
            al = passportImport(new File(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int validpass1 = 0;
        int validpass2 = 0;

        for (String s : al) {
            if (isValidPassportPart1(s)) {
                validpass1++;
            }
            if (isValidPassport2(s)) {
                validpass2++;
            }
        }

        System.out.println("Part 1");
        System.out.println("Total passport: " + al.size());
        System.out.println("Valid passport: " + validpass1);

        System.out.println("Part 2");
        System.out.println("Total passport: " + al.size());
        System.out.println("Valid passport: " + validpass2);

    }

    public static ArrayList<String> passportImport(File f) throws FileNotFoundException {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(f);
        int i = 0;
        while (s.hasNextLine()) {
            String st = s.nextLine();
            if (!st.isEmpty()) {
                sb.append(st).append(" ");
                al.set(i, sb.toString());
            } else {
                al.add("");
                sb = new StringBuilder();
                i++;
            }
        }
        return al;
    }

    public static boolean isFieldExist(String s, String fieldname) {
        return s.contains(fieldname);
    }

    public static boolean isValidPassportPart1(String s) {
        return isFieldExist(s, "byr") &&
                isFieldExist(s, "iyr") &&
                isFieldExist(s, "eyr") &&
                isFieldExist(s, "hgt") &&
                isFieldExist(s, "hcl") &&
                isFieldExist(s, "ecl") &&
                isFieldExist(s, "pid");
    }

    public static String getField(String s, String fieldname) {
        String[] sa = s.split(" ");
        if (isFieldExist(s, fieldname)) {
            for (String value : sa) {
                if (value.contains(fieldname)) {
                    return value.split(":")[1];
                }
            }
        }
        return "-1";
    }

    public static boolean isValidBirthYear(String s) {
        try {
            int a = Integer.parseInt(getField(s, "byr"));
            return 1920 <= a && a <= 2002;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidIssueYear(String s) {
        try {
            int a = Integer.parseInt(getField(s, "iyr"));
            return a >= 2010 && a <= 2020;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidExpirationYear(String s) {
        try {
            int a = Integer.parseInt(getField(s, "eyr"));
            return a >= 2020 && a <= 2030;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidHeight(String s) {
        String st = getField(s, "hgt");
        st = st.toLowerCase();
        if (st.length() == 4) {
            if (st.charAt(2) == 'i' && st.charAt(3) == 'n') {
                if (Character.isDigit(st.charAt(0)) && Character.isDigit(st.charAt(1))) {
                    int a = 10 * Integer.parseInt(String.valueOf(st.charAt(0))) + Integer.parseInt(String.valueOf(st.charAt(1)));
                    return 59 <= a && a <= 76;
                }
            }
        } else if (st.length() == 5) {
            if (st.charAt(3) == 'c' && st.charAt(4) == 'm') {
                if (Character.isDigit(st.charAt(0)) && Character.isDigit(st.charAt(1)) && Character.isDigit(st.charAt(2))) {
                    int a = 100 * Integer.parseInt(String.valueOf(st.charAt(0))) + 10 * Integer.parseInt(String.valueOf(st.charAt(1))) + Integer.parseInt(String.valueOf(st.charAt(2)));
                    return 150 <= a && a <= 193;
                }
            }
        }
        return false;
    }

    public static boolean isValidHairColor(String s) {
        String st = getField(s, "hcl");
        int counter = 6;
        if (st.length() == 7) {
            if (st.charAt(0) == '#') {
                for (int i = 1; i < st.length(); i++) {
                    int a = st.charAt(i);
                    if ((48 <= a && a <= 57) || (65 <= a && a <= 70) || (97 <= a && a <= 102)) {
                        counter--;
                    }
                }
            }
        }
        return counter == 0;
    }

    public static boolean isValidEyeColor(String s) {
        String st = getField(s, "ecl");
        return st.equals("amb") ||
                st.equals("blu") ||
                st.equals("brn") ||
                st.equals("gry") ||
                st.equals("grn") ||
                st.equals("hzl") ||
                st.equals("oth");
    }

    public static boolean isValidPassportNumber(String s) {
        String st = getField(s, "pid");
        if (st.length() == 9) {
            for (char c : st.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidPassport2(String s) {
        return isValidBirthYear(s) &&
                isValidIssueYear(s) &&
                isValidExpirationYear(s) &&
                isValidHeight(s) &&
                isValidHairColor(s) &&
                isValidEyeColor(s) &&
                isValidPassportNumber(s);
    }
}
