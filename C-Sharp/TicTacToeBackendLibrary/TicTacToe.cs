using System.Globalization;
using System.Text;

namespace TicTacToeBackendLibrary
{
    public class TicTacToe
    {
        private readonly IList<string> turnHistory;
        private string?[,] board;
        private IList<string?[,]> boardHistory;
        private int boardSize;
        private int currentPlayer;
        private DateTime endTime;
        private string p1Name;
        private string p1Symbol;
        private string p2Name;
        private string p2Symbol;
        private DateTime startTime;

        /// <summary>
        ///     Default constructor
        /// </summary>
        public TicTacToe()
        {
            currentPlayer = 0;
            startTime = DateTime.Now;
            endTime = DateTime.Now;
            p1Name = "Player 1";
            p2Name = "Player 2";
            p1Symbol = "X";
            p2Symbol = "O";
            const int size = 3;
            boardSize = size;
            board = new string[size, size];
            turnHistory = new List<string>();
            boardHistory = new List<string?[,]>();
        }

        /// <summary>
        ///     Constructor with size parameter
        /// </summary>
        /// <param name="size">Size of the board</param>
        public TicTacToe(int size)
        {
            currentPlayer = 0;
            startTime = DateTime.Now;
            endTime = DateTime.Now;
            p1Name = "Player 1";
            p2Name = "Player 2";
            p1Symbol = "X";
            p2Symbol = "O";
            boardSize = size;
            board = new string[size, size];
            turnHistory = new List<string>();
            boardHistory = new List<string?[,]>();
        }

        /// <summary>
        ///     Constructor with string data parameter
        /// </summary>
        /// <param name="data">Data in format: "P1Name,P2Name,P1Symbol,P2Symbol | StartTime, EndTime | BoardSize | TurnHistory"</param>
        public TicTacToe(string data)
        {
            currentPlayer = 0;
            string[] dataArray = data.Replace(" ", "").Split('|');
            string[] playerData = dataArray[0].Split(',');
            p1Name = playerData[0];
            p2Name = playerData[1];
            p1Symbol = playerData[2];
            p2Symbol = playerData[3];

            string[] timeData = dataArray[1].Split(':');
            startTime = DateTime.Parse(DateTimeOffset.FromUnixTimeSeconds(long.Parse(timeData[0])).ToString());
            endTime = DateTime.Parse(DateTimeOffset.FromUnixTimeSeconds(long.Parse(timeData[1])).ToString());

            boardSize = int.Parse(dataArray[2]);
            board = new string[boardSize, boardSize];

            turnHistory = dataArray[3].Split(",");
            boardHistory = new List<string?[,]>();
            foreach (string bData in turnHistory)
            {
                // Format: "Sym-Row-Col"
                string[] bDataArray = bData.Split('-');
                board[int.Parse(bDataArray[1]), int.Parse(bDataArray[2])] = bDataArray[0];
                boardHistory.Add(board);
            }
        }

        /// <summary>
        ///     Constructor with list of data parameter
        /// </summary>
        /// <param name="dataArray">Data format: "P1Name,P2Name,P1Symbol,P2Symbol | StartTime, EndTime | BoardSize | TurnHistory"</param>
        public TicTacToe(IReadOnlyList<string> dataArray)
        {
            currentPlayer = 0;
            string[] playerData = dataArray[0].Split(',');
            p1Name = playerData[0];
            p2Name = playerData[1];
            p1Symbol = playerData[2];
            p2Symbol = playerData[3];

            string[] timeData = dataArray[1].Split(':');
            startTime = DateTime.Parse(DateTimeOffset.FromUnixTimeSeconds(long.Parse(timeData[0])).ToString());
            endTime = DateTime.Parse(DateTimeOffset.FromUnixTimeSeconds(long.Parse(timeData[1])).ToString());

            boardSize = int.Parse(dataArray[2]);

            board = new string[boardSize, boardSize];
            turnHistory = dataArray[3].Split(",");
            boardHistory = new List<string?[,]>();
            foreach (string bData in turnHistory)
            {
                // Format: "Sym-Row-Col"
                string[] bDataArray = bData.Split('-');
                board[int.Parse(bDataArray[1]), int.Parse(bDataArray[2])] = bDataArray[0];
                boardHistory.Add(board);
            }
        }

        public string?[,] Board
        {
            get { return board; }
            set { board = value; }
        }

        public IList<string?[,]> BoardHistory
        {
            get { return boardHistory; }
            set { boardHistory = value; }
        }

        public int BoardSize
        {
            get { return boardSize; }
            set { boardSize = value; }
        }

        public int CurrentPlayer
        {
            get { return currentPlayer; }
            set { currentPlayer = value is 0 or 1 ? value : 0; }
        }

        public DateTime EndTime
        {
            get { return endTime; }
            set { endTime = value; }
        }

        public string P1Name
        {
            get { return p1Name; }
            set { p1Name = value; }
        }

        public string P1Symbol
        {
            get { return p1Symbol; }
            set { p1Symbol = value; }
        }

        public string P2Name
        {
            get { return p2Name; }
            set { p2Name = value; }
        }

        public string P2Symbol
        {
            get { return p2Symbol; }
            set { p2Symbol = value; }
        }

        public DateTime StartTime
        {
            get { return startTime; }
        }

        public IList<string> TurnHistory
        {
            get { return turnHistory; }
        }

        /// <summary>
        ///     Print jagged array as string with each array on a separate line
        ///     Basically java.util.Arrays.deepToString but multi-line
        /// </summary>
        /// <param name="boardData">Jagged string array</param>
        /// <returns>String array</returns>
        public static string BoardDisplay(string?[,] boardData)
        {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < boardData.GetLength(0); i++)
            {
                for (int j = 0; j < boardData.GetLength(1); j++)
                    result.Append(boardData[i, j] is null ? "-" : boardData[i, j]).Append(" | ");

                result.Remove(result.Length - 3, 3);
                result.Append('\n');
            }

            return result.Remove(result.Length - 1, 1).ToString();
        }

        /// <summary>
        ///     Print jagged array as string with each array on a separate line
        ///     Called directly on the boardData array
        /// </summary>
        /// <returns>BoardData Array</returns>
        public string BoardDisplay()
        {
            return BoardDisplay(board);
        }

        private string GetCurrentPlayerSymbol(int playerNo)
        {
            return (playerNo % 2) switch
            {
                0 => p1Symbol,
                1 => p2Symbol,
                _ => GetCurrentPlayerSymbol(playerNo % 2)
            };
        }

        public string GetWinner()
        {
            string winner = string.Empty;
            if (IsWinner(p1Symbol))
                winner = p1Name;
            else if (IsWinner(p2Symbol))
                winner = p2Name;
            else if (IsFilled())
                winner = "No one";

            return winner;
        }

        /// <summary>
        ///     Find the non-empty cells in the board
        /// </summary>
        /// <returns>True if there is no empty cell, false otherwise</returns>
        public bool IsFilled()
        {
            for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                if (board[i, j] is null)
                    return false;
            return true;
        }

        /// <summary>
        ///     Check if game is over
        /// </summary>
        /// <returns>True if game over</returns>
        public bool IsGameOver()
        {
            return !string.IsNullOrEmpty(GetWinner());
        }

        /// <summary>
        ///     Check if move is valid
        /// </summary>
        /// <param name="move">
        ///     Move description in string
        ///     Format: Symbol-Row-Column
        /// </param>
        /// <returns>True if valid</returns>
        public bool IsValidMove(string move)
        {
            return IsValidMove(move.Split("-"));
        }

        /// <summary>
        ///     Check if move is valid
        /// </summary>
        /// <param name="move">
        ///     Move description in string
        ///     Format: Symbol-Row-Column
        /// </param>
        /// <returns>True if valid</returns>
        public bool IsValidMove(string[] move)
        {
            return int.TryParse(move[1], out int row) && int.TryParse(move[2], out int column) &&
                   IsValidMove(row, column);
        }

        /// <summary>
        ///     Check if move is valid
        /// </summary>
        /// <param name="row">Row of move</param>
        /// <param name="column">Column of move</param>
        /// <returns>True if valid</returns>
        public bool IsValidMove(int row, int column)
        {
            return string.IsNullOrEmpty(board[row, column]);
        }

        /// <summary>
        ///     Check if particular symbol wins
        /// </summary>
        /// <param name="symbol">Symbol needed to check</param>
        /// <returns>True if winner</returns>
        public bool IsWinner(string symbol)
        {
            bool winner = false;
            // Check rows
            for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
            {
                if (board[i, j] != symbol) break;

                if (j == boardSize - 1) winner = true;
            }

            // Check columns
            for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
            {
                if (board[j, i] != symbol) break;

                if (j == boardSize - 1) winner = true;
            }

            // Check diagonals left to right
            for (int i = 0; i < boardSize; i++)
            {
                if (board[i, i] != symbol) break;

                if (i == boardSize - 1) winner = true;
            }

            // Check diagonals right to left
            for (int i = 0; i < boardSize; i++)
            {
                if (board[i, boardSize - 1 - i] != symbol) break;

                if (i == boardSize - 1) winner = true;
            }

            return winner;
        }

        /// <summary>
        ///     Move symbol to position on board
        /// </summary>
        /// <param name="row">Row of move</param>
        /// <param name="column">Column of move</param>
        /// <returns>True if valid move</returns>
        public bool Move(int row, int column)
        {
            string symbol = GetCurrentPlayerSymbol(currentPlayer);

            currentPlayer++; // Next player

            return Move(string.Join("-", symbol, row.ToString(), column.ToString()));
        }

        public bool Move(int[] move)
        {
            return move.Length == 2 && Move(move[0], move[1]);
        }

        /// <summary>
        ///     Move symbol to position
        /// </summary>
        /// <param name="move">
        ///     Move data
        ///     Format: Symbol-Row-Column
        /// </param>
        /// <returns>True if move is valid</returns>
        public bool Move(string move)
        {
            return Move(move.Split("-"));
        }

        /// <summary>
        ///     Move symbol to position
        /// </summary>
        /// <param name="move">Move data</param>
        /// <returns>True if move is valid</returns>
        public bool Move(string[] move)
        {
            if (!IsValidMove(move) || IsGameOver()) return false;
            string symbol = move[0];
            int row = int.Parse(move[1]);
            int col = int.Parse(move[2]);
            endTime = DateTime.Now;

            board[row, col] = symbol;
            turnHistory.Add(string.Join("-", move));
            ;
            boardHistory.Add(board);
            if (turnHistory.Count == 0)
                startTime = DateTime.Now;
            endTime = DateTime.Now;
            return true;
        }
        // There is a TicTaxToe.Computer.Minimax.cs file but it is copied code from G4G so it is not suitable for submission

        /// <summary>
        ///     Randomize a move from computer
        /// </summary>
        /// <returns>Integer array representing the coordinate of the move</returns>
        public int[] RandomComputerMoveIntegerArray()
        {
            if (IsGameOver())
                return new int[] {-1, -1};
            Random r = new Random();
            int row, column;
            do
            {
                row = r.Next(boardSize);
                column = r.Next(boardSize);
            } while (!IsValidMove(row, column));

            return new int[] {row, column};
        }

        /// <summary>
        ///     Randomize a move from computer
        /// </summary>
        /// <returns>Tuple of integers representing the coordinate of the move</returns>
        public (int, int) RandomComputerMoveIntegerTuple()
        {
            if (IsGameOver())
                return (-1, -1);
            Random r = new Random();
            int row, column; // For now it is integers, long is only good if you have bigger board.
            do
            {
                row = r.Next(boardSize);
                column = r.Next(boardSize);
            } while (!IsValidMove(row, column));

            return (row, column);
        }

        /// <summary>
        ///     Reset the game, but keep the players and symbols
        /// </summary>
        public void Reset()
        {
            turnHistory.Clear();
            board = new string[boardSize, boardSize];
            boardHistory.Clear();
            startTime = DateTime.Now;
            endTime = DateTime.Now;
        }

        /// <summary>
        ///     Return match data in string
        ///     Format:
        ///     "p1Name,p2Name,p1Symbol,p2Symbol|startTime|endTime|boardSize|turnHistory"
        /// </summary>
        /// <returns>Match data in string</returns>
        public override string ToString()
        {
            return
                $"{p1Name},{p2Name},{p1Symbol},{p2Symbol}|{new DateTimeOffset(startTime).ToUnixTimeMilliseconds().ToString(CultureInfo.InvariantCulture)}:{new DateTimeOffset(endTime).ToUnixTimeMilliseconds().ToString(CultureInfo.InvariantCulture)}|{boardSize}|{string.Join(",", turnHistory)}";
        }

        /// <summary>
        ///     Return the same string as ToString but in the StringBuilder class
        /// </summary>
        /// <returns></returns>
        public StringBuilder ToStringBuilder()
        {
            return new StringBuilder()
                .Append(p1Name).Append(',').Append(p2Name).Append(',')
                .Append(p1Symbol).Append(',').Append(p2Symbol).Append('|')
                .Append(new DateTimeOffset(startTime).ToUnixTimeSeconds().ToString(CultureInfo.InvariantCulture))
                .Append(':')
                .Append(new DateTimeOffset(endTime).ToUnixTimeSeconds().ToString(CultureInfo.InvariantCulture))
                .Append('|')
                .Append(boardSize).Append('|')
                .Append(string.Join(",", turnHistory));
        }

        /// <summary>
        ///     Undo last move
        /// </summary>
        /// <param name="row"></param>
        /// <param name="column"></param>
        /// <returns>True if successful</returns>
        public bool UndoMove(int row, int column)
        {
            if (row < 0 || row > boardSize || column < 0 || column > boardSize ||
                string.IsNullOrEmpty(board[row, column]))
                return false;
            board[row, column] = null;
            turnHistory.RemoveAt(turnHistory.Count - 1);
            boardHistory.RemoveAt(boardHistory.Count - 1);
            return true;
        }
    }
}