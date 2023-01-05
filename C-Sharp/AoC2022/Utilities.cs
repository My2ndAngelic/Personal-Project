using System.Reflection;
using System.Runtime.InteropServices.ComTypes;

namespace AoC2022
{
    public class Utilities
    {
        public static string[] FileReaderStringPathToStringArray(string path)
        {
            string[] result = Array.Empty<string>();
            try
            {
                result = File.ReadAllLines(path);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }

            return result;
        }
        
        public static string FileReaderStringPathToString(string path)
        {
            string result = string.Empty;
            try
            {
                result = File.ReadAllText(path);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }

            return result;
        }

        public static int Mod(int div, int mod)
        {
            return div < 0 ? (div % mod + mod) % mod : div % mod;
        }
    }
}