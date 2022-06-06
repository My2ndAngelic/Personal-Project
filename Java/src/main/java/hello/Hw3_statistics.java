package hello;

import java.io.IOException;

public class Hw3_statistics {

    public static void main(String[] args) throws IOException {
        int id = 0;
        int right = 1;
        int wrong = 2;
        int answered = 3;
        int omitted = 4;
        int grade = 5;
        double cap = 6.0;

        //cap is correct answer percentage
        String s1 = String.format("%10s %10s %10s %10s %10s %10s %10s", "ID", "Right", "Wrong", "Answered", "Omitted", "Grade", "Cap");
        String s2 = String.format("%10s %10s %10s %10s %10s %10s %10s", id, right, wrong, answered, omitted, grade, cap);
        String s3 = String.format("%10s %10s %10s %10s %10s %10s %10s", 100, 69, 420, 69420, 0, 1337, 1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}