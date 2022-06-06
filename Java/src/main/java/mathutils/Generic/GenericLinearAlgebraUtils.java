package mathutils.Generic;


public class GenericLinearAlgebraUtils { // Unfinished code, bug expected

    /**
     * Check if your input is a 2D-filled matrix.
     *
     * @param input A
     * @param <T>   A
     * @return A
     */
    public static <T extends Number> Boolean isMatrix(T[][] input) {
        T[] temp = input[0];
        for (T[] a : input) {
            if (a.length != temp.length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Extract row from your matrix. Row starts from 1.
     *
     * @param input the matrix in 2D array format
     * @param no    the row you want to extract
     * @param <T>   type of the input
     * @return data from the row
     */
    public static <T extends Number> T[] rowExtract(T[][] input, Integer no) {
        if (no > input.length || no <= 0) {
            throw new IndexOutOfBoundsException("There is no such row in your matrix.");
        } else {
            T[] output = (T[]) new Number[input[no - 1].length];
            System.arraycopy(input[no], 0, output, 0, input[no].length);
            return output;
        }
    }

    public static <T extends Number> T[] columnExtract(T[][] input, Integer no) {
        if (no > input[0].length || no <= 0) {
            throw new IndexOutOfBoundsException("There is no such column in your matrix.");
        } else {
            T[] output = (T[]) new Number[input[no - 1].length];
            for (int i = 0; i < input.length; i++) {
                output[i] = input[i][no - 1];
            }
            return output;
        }
    }
}
