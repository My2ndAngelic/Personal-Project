using System;
using System.IO;
using System.Linq;
using System.Management.Instrumentation;
using System.Reflection;

namespace AoC2020
{
    public static class Day2
    {
        public static void D2()
        {
            var a = AoC2020.Utilities.FileReaderFromDayNo(2);

            // Password rule
            var b1 = new int[a.Length];
            var b2 = new int[a.Length];
            var b3 = new char[a.Length];
            var b4 = new string[a.Length];
            for (var i = 0; i < a.Length; i++)
            {
                var s = a[i].Split(' ');
                b1[i] = int.Parse(s[0].Split('-')[0]);
                b2[i] = int.Parse(s[0].Split('-')[1]);
                b3[i] = char.Parse(s[1].Split(':')[0]);
                b4[i] = s[2];
            }

            // Part 1
            var validPass1 = 0;
            for (var i = 0; i < a.Length; i++)
            {
                var bb4 = b4[i].Count(x => x == b3[i]);
                if (b1[i] <= bb4 && bb4 <= b2[i])
                {
                    validPass1++;
                }
            }

            Console.WriteLine(validPass1);
            // Part 2
            var validPass2 = 0;

            for (var i = 0; i < a.Length; i++)
            {
                try
                {
                    var bb1 = b4[i][b1[i] - 1];
                    var bb2 = b4[i][b2[i] - 1];
                    if (bb1 == b3[i] ^ bb2 == b3[i])
                    {
                        validPass2++;
                    }
                }
                catch (IndexOutOfRangeException)
                {
                    // ignored
                }
            }

            // CSharp_DNF.WriteLine(b1.Length + " " + b2.Length + " " + b3.Length + " " + b4.Length);
            Console.WriteLine(validPass2);
            Console.ReadLine();
        }
    }
}