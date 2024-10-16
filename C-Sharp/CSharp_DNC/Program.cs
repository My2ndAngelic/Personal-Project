﻿using System;
using System.Globalization;

namespace CSharp_DNC
{
    public static class Program
    {
        public static double Coordinate2D(string coordinateInput)
        {
            return Math.Sqrt(Math.Pow(
                                 double.Parse(coordinateInput.Trim()
                                     .Replace(" ",
                                         string.Empty)
                                     .Replace("(",
                                         string.Empty)
                                     .Replace(")",
                                         string.Empty)
                                     .Split(",")[0]) -
                                 double.Parse(coordinateInput.Trim()
                                     .Replace(" ",
                                         string.Empty)
                                     .Replace("(",
                                         string.Empty)
                                     .Replace(")",
                                         string.Empty)
                                     .Split(",")[2]), 2)
                             +
                             Math.Pow(
                                 double.Parse(coordinateInput.Trim()
                                     .Replace(" ",
                                         string.Empty)
                                     .Replace("(",
                                         string.Empty)
                                     .Replace(")",
                                         string.Empty)
                                     .Split(",")[1]) -
                                 double.Parse(coordinateInput.Trim()
                                     .Replace(" ",
                                         string.Empty)
                                     .Replace("(",
                                         string.Empty)
                                     .Replace(")",
                                         string.Empty)
                                     .Split(",")[3]), 2));
        }

        public static void Main(string[] args)
        {
            Console.WriteLine(0.00000005.ToString(CultureInfo.CurrentCulture));
        }
    }
}