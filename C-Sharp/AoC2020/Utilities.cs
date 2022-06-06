using System.IO;
using System.Reflection;

namespace AoC2020
{
    public static class Utilities
    {

        public static string[] FileReaderFromDayNo(int dayNo)
        {
            try
            {
                return File.ReadAllLines(Path.GetFullPath(Path.Combine(Directory.GetCurrentDirectory(), "..", "..",
                    "input", "input" + dayNo + "." + "txt")));
            }
            catch (FileNotFoundException)
            {
                throw new FileNotFoundException("Fix " + MethodBase.GetCurrentMethod().Name + " method please.");
            }
        }
    }
}