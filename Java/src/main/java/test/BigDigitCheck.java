package test;

import java.math.BigInteger;

public class BigDigitCheck {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger(String.valueOf(9));
        for (int i = 1; i <= 50; i++) {
            BigInteger output = bi.pow(i);
            System.out.printf("9^%s = %s | %s%n", i, output, output.toString().length());
        }
    }
}
