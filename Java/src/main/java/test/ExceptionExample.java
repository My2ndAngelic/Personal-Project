package test;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            System.out.println(sumTwoPositiveInteger(6, 9));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    public static int sumTwoPositiveInteger(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("You can only put positive number.");
        }
        return a + b;
    }
}
