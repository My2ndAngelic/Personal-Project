package mathutils;

import mathutils.Generic.GenericLinearAlgebraUtils;

import java.util.Arrays;

public class MathTest {
    public static void main(String[] args) {
        Integer[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(Arrays.toString(GenericLinearAlgebraUtils.columnExtract(a, 1)));
    }
}
