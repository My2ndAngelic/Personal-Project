namespace CSharp_DNF.MathUtils
{
    public class LinearAlgebraUtils
    {
        public static double[] RowExtractor(double[,] a, int rowNo)
        {
            var c = new double[a.GetLength(0)];
            for (var i = 0; i < c.Length; i++) c[i] = a[i, rowNo];
            return c;
        }

        public static double[] ColumnExtractor(double[,] a, int rowNo) // Not yet implemented
        {
            var c = new double[a.GetLength(0)];
            return c;
        }
    }
}