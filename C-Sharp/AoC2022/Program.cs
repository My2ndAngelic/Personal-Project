// See https://aka.ms/new-console-template for more information

using System.Reflection;
using System.Text.RegularExpressions;
using AoC2022;

Console.WriteLine("Hello, World!");

string path = @"C:\Users\My2ndAngelic\Documents\GitHub\Personal-Project\C-Sharp\AoC2022\input";


IEnumerable<Type> listType = Assembly.GetExecutingAssembly()
    .GetTypes()
    .Where(t => t is {IsClass: true, Namespace: "AoC2022"} && Regex.IsMatch(t.Name, @"Day[0-9]+"));

foreach (Type type in listType)
{
    string dayInfo = type.Name[^1].ToString();
    string para = Utilities.FileReaderStringPathToString(path + $@"/input{dayInfo}.txt");
    List<string?> result = type
        .GetMethods(BindingFlags.Public | BindingFlags.Static)
        .Where(mi => Regex.IsMatch(mi.Name, @"P[0-9]+"))
        .Select(mi => mi.Invoke(null, new object?[] {para}))
        .Select(s => s?.ToString())
        .ToList();
    Console.WriteLine($@"Day {type.Name[^1]}: {result[0]} | {result[1]}");
}


// using AoC2022;
//
// Console.WriteLine(Day2.MyCounterMove(0, 'Z'));
// Console.WriteLine(Day2.MyCounterMove(1, 'Z'));
// Console.WriteLine(Day2.MyCounterMove(2, 'Z'));