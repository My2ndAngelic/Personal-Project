package mathutils.Generic;

public interface IGenericLinearAlgebra<T extends Number> {
    T[][] matrixAdd(T[][] a, T[][] b);

    T[][] matrixSubtract(T[][] a, T[][] b);

    T[][] matrixInverse(T[][] input);

    T matrixDeterminant(T[][] input);

    T[][] constantMultiply(T[][] input, T constant);

    T[][] matrixMultiply(T[][] a, T[][] b);

    Boolean isMatrix(T[][] input);
}
