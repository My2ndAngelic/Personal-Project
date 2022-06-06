package aoc.AoC2020;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("tttt");
        for (int i = 0; i < sb.length(); i++) {
            int a = sb.indexOf(Character.toString(sb.charAt(i)));
            int b = sb.lastIndexOf(Character.toString(sb.charAt(i)));
            if (a != b) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(sb);
    }
}
