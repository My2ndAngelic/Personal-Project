﻿using System;

namespace AoC2020
{
    internal class Day1
    {
        public static void D1()
        {
            Console.WriteLine();
            var a = Utilities.FileReaderFromDayNoStringArray(1);
            var data = new int[a.Length];
            for (var i = 0; i < a.Length; i++) data[i] = int.Parse(a[i]);

            for (var i = 0; i < data.Length - 1; i++)
            for (var j = i + 1; j < a.Length; j++)
            {
                if (data[i] + data[j] == 2020)
                {
                    Console.WriteLine(data[i] + " " + data[j]);
                    Console.WriteLine(data[i] * data[j]);
                    Console.WriteLine();
                }

                for (var k = j + 1; k < a.Length; k++)
                {
                    if (data[i] + data[j] + data[k] != 2020) continue;
                    Console.WriteLine(data[i] + " " + data[j] + " " + data[k]);
                    Console.WriteLine(data[i] * data[j] * data[k]);
                    Console.WriteLine();
                }
            }

            Console.ReadLine();
        }
    }
}