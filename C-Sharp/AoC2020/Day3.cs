using System;
using System.IO;
using System.Linq;
using System.Management.Instrumentation;
using System.Reflection;

namespace AoC2020
{
    public static class Day3
    {
        public static void D3()
        {
            var a = AoC2020.Utilities.FileReaderFromDayNo(3);

            int TreeCounter(string[] array, int right, int down)
            {
                var tree = 0;
                for (var i = 0; i < a.Length; i += down)
                {
                    if (a[i][right * i % a[i].Length].Equals('#'))
                    {
                        tree++;
                    }
                }
                return tree;
            }

            Console.WriteLine(TreeCounter(a, 3, 1));


            var tempout2 = new[] {TreeCounter(a, 1, 1),
                TreeCounter(a, 3, 1),
                TreeCounter(a, 5, 1),
                TreeCounter(a, 7, 1),
                TreeCounter(a, 1, 2)
            };

            // CSharp_DNF.WriteLine("[" + string.Join(", ", tempout2) + "]");

            var b = tempout2.Aggregate<int, long>(1, (current, i) => current * i);
            Console.WriteLine(b);
        }
    }
}