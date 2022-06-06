using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp_DNC.MathUtils
{
    public class TemperatureConvertLibrary
    {
        public static readonly Func<string, double> TempConvert2 = s =>
            Math.Pow((double) 5 / 9, s[^1..0].Equals("F") ? 1 : 0) *
            (
                Math.Pow(-1, s[^1..].Equals("F") ? 1 : 0) * 32 +
                Math.Pow(1.8, !s[^1..].Equals("F") ? 1 : 0) * Convert.ToDouble(s[..^1])
            );

        public static readonly Func<string, double> TempConvert3 = s => new List<double>
        {
            9 * Convert.ToDouble(s[..^1]) / 5 + 32,
            (Convert.ToDouble(s[..^1]) - 32) * 5 / 9
        }[s[^1..].Equals("F") ? 1 : 0];

        /// <summary>
        ///     Convert your temperature to Celcius.
        ///     Format: 69F or 420.15K or 37C
        ///     Return type: String
        /// </summary>
        public static readonly Func<string, string> InCelcius = s => new List<double>
        {
            Convert.ToDouble(s[..^1]),
            Convert.ToDouble(s[..^1]) - 273.15,
            (Convert.ToDouble(s[..^1]) - 32) * 5 / 9
        }[new List<string>
        {
            "C",
            "K",
            "F"
        }.IndexOf(s[^1..])].ToString("F2") + "C";

        public static readonly Func<string, string> TempConvertInOutString = s => Convert.ToDouble(new Hashtable
        {
            {"CC", Convert.ToDouble(s[..^2])},
            {"FF", Convert.ToDouble(s[..^2])},
            {"KK", Convert.ToDouble(s[..^2])},
            {"KC", Convert.ToDouble(s[..^2]) - 273.15},
            {"CK", Convert.ToDouble(s[..^2]) + 273.15},
            {"FC", (Convert.ToDouble(s[..^2]) - 32) * 5 / 9},
            {"CF", 9 * Convert.ToDouble(s[..^2]) / 5 + 32},
            {"FK", (Convert.ToDouble(s[..^2]) - 32) * 5 / 9 + 273.15},
            {"KF", 9 * (Convert.ToDouble(s[..^2]) - 273.15) / 5 + 32}
        }[s[^2..]]).ToString("F2") + s[^1..];

        public static readonly Func<string, double> TempConvertInOutDouble = s => Convert.ToDouble(new Hashtable
        {
            {"CC", Convert.ToDouble(s[..^2])},
            {"FF", Convert.ToDouble(s[..^2])},
            {"KK", Convert.ToDouble(s[..^2])},
            {"KC", Convert.ToDouble(s[..^2]) - 273.15},
            {"CK", Convert.ToDouble(s[..^2]) + 273.15},
            {"FC", (Convert.ToDouble(s[..^2]) - 32) * 5 / 9},
            {"CF", 9 * Convert.ToDouble(s[..^2]) / 5 + 32},
            {"FK", (Convert.ToDouble(s[..^2]) - 32) * 5 / 9 + 273.15},
            {"KF", 9 * (Convert.ToDouble(s[..^2]) - 273.15) / 5 + 32}
        }[s[^2..]]);

        private static double TempConvert(double temp, string sourceUnit)
        {
            return Math.Pow((double) 5 / 9, sourceUnit.Equals("F") ? 1 : 0) *
                   (
                       Math.Pow(-1, sourceUnit.Equals("F") ? 1 : 0) * 32 +
                       Math.Pow(1.8, !sourceUnit.Equals("F") ? 1 : 0) * temp
                   );
        }
    }
}