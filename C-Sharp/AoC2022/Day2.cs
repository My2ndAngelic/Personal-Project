namespace AoC2022
{
    public class Day2
    {
        public static long P1(string dataIn)
        {
            string[] data = dataIn.Split("\n");

            long result = 0;
            foreach (string s in data)
            {
                if (s == string.Empty) continue;
                int yourMove = MoveData(s[0]);
                int myMove = MoveData(s[^1]);
                switch (diff(yourMove, myMove))
                {
                    case 0:
                        result += 3;
                        break;
                    case 1:
                        result += 0;
                        break;
                    case 2:
                        result += 6;
                        break;
                }

                result += myMove + 1;
            }

            return result;
        }

        public static long P2(string dataIn)
        {
            string[] data = dataIn.Split("\n");

            long result = 0;
            foreach (string s in data)
            {
                if (s == string.Empty) continue;
                int yourMove = MoveData(s[0]);
                int myMove = MyCounterMove(yourMove, s[^1]);
                switch (diff(yourMove, myMove))
                {
                    case 0:
                        result += 3;
                        break;
                    case 1:
                        result += 0;
                        break;
                    case 2:
                        result += 6;
                        break;
                }

                result += myMove + 1;
            }
            return result;
        }

        private static int MoveData(char moveChar)
        {
            return moveChar switch
            {
                'A' or 'X' => 0,
                'B' or 'Y' => 1,
                'C' or 'Z' => 2,
                _ => throw new ArgumentOutOfRangeException(nameof(moveChar), moveChar, null)
            };
        }

        private static int diff(int yourMove, int myMove)
        {
            return Utilities.Mod(yourMove - myMove, 3);
        }

        private static char MoveChar(int moveData, bool yom)
        {
            return yom switch
            {
                true => moveData switch
                {
                    0 => 'A',
                    1 => 'B',
                    2 => 'C',
                    _ => throw new Exception("Invalid argument")
                },
                false => moveData switch
                {
                    0 => 'X',
                    1 => 'Y',
                    2 => 'Z',
                    _ => throw new Exception("Invalid argument.")
                }
            };
        }
        
        private static int MyCounterMove(int yourMoveData, char myResult)
        {
            return myResult switch
            {
                'X' => Utilities.Mod(yourMoveData + 2, 3),
                'Y' => Utilities.Mod(yourMoveData, 3),
                'Z' => Utilities.Mod(yourMoveData + 1, 3),
                _ => throw new ArgumentException("Invalid argument.")
            };
        }
    }
}