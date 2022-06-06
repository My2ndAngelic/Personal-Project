package test;

import java.util.Arrays;

public class SortBubble2D {

    public static void main(String[] args) {
        int[][] aCopy = {{1, 11, 11, 11}, {7, 77, 77, 77}, {2, 22, 22, 22}, {5, 55, 55, 55}, {9, 99, 99, 99}, {8, 88, 88, 88}};

        int length = aCopy.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (aCopy[j][0] > aCopy[j + 1][0]) {
                    swapRow(aCopy, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.deepToString(aCopy));
    }

    public static void swapRow(int[][] a, int rowA, int rowB) {
        for (int i = 0; i < a[0].length; i++) {
            int temp = a[rowA][i];
            a[rowA][i] = a[rowB][i];
            a[rowB][i] = temp;
        }
    }
}
