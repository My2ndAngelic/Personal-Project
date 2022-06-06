package mathutils;

public class BasicMathUtils {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a + (-b);
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        } else {
            return a / b;
        }
    }

    public static long EuclidGCD(long a, long b) {
        if (a < 0 || b < 0) {
            throw new ArithmeticException("No");
        } else if (a == 0 || b == 0) {
            return 0;
        } else if (a == b) {
            return a;
        } else if (a > b) {
            return EuclidGCD(a - b, b);
        } else {
            return EuclidGCD(a, b - a);
        }
    }

    public static long floor(double a) {
        return getIntegerPart(a);
    }

    public static long getIntegerPart(double a) {
        return (long) (a - (a % 1));
    }

    public static long ceiling(double a) {
        if (getDecimalPart(a) > 0) {
            return getIntegerPart(a) + 1;
        } else {
            return getIntegerPart(a);
        }
    }

    public static double getDecimalPart(double a) {
        return a - getIntegerPart(a);
    }
}
