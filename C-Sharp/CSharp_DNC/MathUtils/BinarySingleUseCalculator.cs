using System;

namespace CSharp_DNC.MathUtils
{
    public class BinarySingleUseCalculator
    {
        private double Ans;
        private double Number1;
        private double Number2;

        private BinarySingleUseCalculator()
        {
            Number1 = 0;
            Number2 = 0;
            Ans = 0;
        }

        private BinarySingleUseCalculator(double Number1, double Number2)
        {
            this.Number1 = Number1;
            this.Number2 = Number2;
            Ans = 0;
        }

        public double Add()
        {
            Ans = Number1 + Number2;
            return Ans;
        }

        public double Subtract()
        {
            Ans = Number1 - Number2;
            return Ans;
        }

        public double Multiplication()
        {
            Ans = Number1 * Number2;
            return Ans;
        }

        public double Division()
        {
            Ans = Number1 / Number2;
            return Ans;
        }

        public double FloorGCD()
        {
            var Number1 = (int) this.Number1;
            var Number2 = (int) this.Number2;

            while (Number1 != Number2)
                if (Number1 > Number2)
                    Number1 -= Number2;
                else
                    Number2 -= Number1;
            Ans = Number1;
            return Ans;
        }

        public double Exponential()
        {
            Ans = Math.Pow(Number1, Number2);
            return Ans;
        }

        public double GetAns()
        {
            return Ans;
        }

        public void Enter(double Number1, double Number2)
        {
            this.Number1 = Number1;
            this.Number2 = Number2;
        }

        public void Reset()
        {
            Number1 = 0;
            Number2 = 0;
            Ans = 0;
        }
    }
}