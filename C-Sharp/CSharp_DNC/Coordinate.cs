using System;

namespace CSharp_DNC
{
    public static class Coordinate
    {
        /// <summary>
        ///     Return distance given coordinates in 2D
        /// </summary>
        /// <param name="coordinateInput">Enter coordinate in the form of "(a, b), (c, d)"</param>
        /// <returns>Distance in double</returns>
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

        public static string[] ReturnCoordinate(string coordinateInput)
        {
            return coordinateInput.Trim().Replace(" ", string.Empty).Split(",");
        }
    }
}