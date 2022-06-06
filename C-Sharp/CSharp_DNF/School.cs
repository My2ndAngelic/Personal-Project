namespace CSharp_DNF
{
    public class School
    {
        private readonly int Age;
        private readonly string Name;

        public School(string name, int age)
        {
            Age = age;
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }

        public int GetAge()
        {
            return Age;
        }
    }

    internal class Teacher : School
    {
        private string Subject;
        private int Time;

        public Teacher(string name, int age, int time, string subject) : base(name, age)
        {
            Time = time;
            Subject = subject;
        }

        public override string ToString()
        {
            return "Teacher " + base.ToString();
        }
    }

    internal class Student : School
    {
        private readonly string Level;

        private readonly string Rank;

        public Student(string name, int age, string level, string rank) : base(name, age)
        {
            Level = level;
            Rank = rank;
        }

        public string GetLevel()
        {
            return Level;
        }

        public string GetRank()
        {
            return Rank;
        }

        public override string ToString()
        {
            return "Student: " + GetName() + " " + GetAge() + " " + GetLevel() + " " + GetRank();
        }
    }
}