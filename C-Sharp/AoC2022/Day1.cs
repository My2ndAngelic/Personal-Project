using System.Collections;

namespace AoC2022
{
    public class Day1
    {
        public static long P1(string dataIn)
        {
            IEnumerable<long> process = dataProcessing(dataIn);
            long result = process.Max(e => e);

            return result;
        }

        public static long P2(string dataIn)
        {
            List<long> process = dataProcessing(dataIn);
            process.Sort();
            process.Reverse();
            long result = process[0] + process[1] + process[2];
            return result;
        }

        private static List<long> dataProcessing(string dataIn)
        {
            string[] data = dataIn.Split("\n\n");
            List<long> process = new List<long>();

            foreach (string s in data)
            {
                string[] ss = s.Split("\n");
                long tempRes = 0;
                foreach (string sss in ss)
                {
                    long.TryParse(sss, out long temp);
                    tempRes += temp;
                }

                process.Add(tempRes);
            }

            return process;
        }
    }
}