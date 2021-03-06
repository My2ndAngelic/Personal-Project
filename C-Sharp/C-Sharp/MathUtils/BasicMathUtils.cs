using System;

namespace CSharp.MathUtils
{
    public class BasicMathUtils
    {
        public static long EuclidGCD(long a, long b)
        {
            if (a < 0 || b < 0)
            {
                throw new Exception("We don't do that here");
            }

            while (a != b)
                if (a > b)
                    a -= b;
                else
                    b -= a;
            return a;
        }

        public static bool Palindrome(string str)
        {
            string tmp = str.ToLower();
            char[] c = tmp.ToCharArray();
            tmp = "";
            // String cleaner
            for (int i = 0; i < c.Length; i++)
                if (char.IsLetterOrDigit(c[i]))
                    tmp += c[i];
            string tmp2 = "";
            for (int i = 0; i < tmp.Length; i++) {
                tmp2 += tmp.Substring(tmp.Length - i - 1, 1);
            }
			return string.Equals(tmp, tmp2);
        }

        public static class SF1947
        {
            public static long LeMain(long input)
            {
                input = Div8(input);
                input = Div9(input);
                return input;
            }

            private static long Div8(long a)
            {
                a *= 10;
				for (int i = 0; i < 10; i++)
                {
                    a++;
                    if (a % 8 == 0) {
						break;
                    }
                }

                return a;
            }

            private static long Div9(long a)
            {
                long tmp = DigitCount(a);
                for (int i = 0; i < 10; i++)
                {
                    a += (long) Math.Pow(10, tmp) * i;
                    if (a % 9 == 0) break;
                }

                return a;
            }

            private static long DigitCount(long a)
            {
                long dc = 0;
                while (a != 0)
                {
                    a /= 10;
                    dc++;
                }

                return dc;
            }
        }

        public static double Add(double a, double b)
        {
            return a + b;
        } 

        public static double Subtract(double a, double b)
        {
            return a - b;
        }

        public static double Multiply(double a, double b)
        {
            return a * b; 
        }

        public static double Divide(double a, double b)
        {
            if (b == 0)
            {
                throw new ArithmeticException("Divide by 0");
            }
            else
            {
                return a / b;
            }
        }

        public static long GetIntegerPart(double a)
        {
            return (long) (a / 1);
        }

        public static long GetDecimalPart(double a)
        {
            return (long) (a % 1);
        }
    }
}