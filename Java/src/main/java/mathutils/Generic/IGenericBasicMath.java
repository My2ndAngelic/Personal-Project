package mathutils.Generic;

public interface IGenericBasicMath<T extends Number> {
    T add(T a, T b);

    T subtract(T a, T b);

    T multiply(T a, T b);

    T divide(T a, T b);

    T EuclidGCD(T a, T b);
}
