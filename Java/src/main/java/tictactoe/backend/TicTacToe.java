package tictactoe.backend;

import com.google.common.base.Strings;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public @Data class TicTacToe {
    private final List<String> turnHistory;
    private final List<String[][]> boardHistory;
    private final int boardSize;
    private final String p1Symbol;
    private final String p1Name;

    private final String p2Name;
    private final String p2Symbol;
    private String[][] board;
    private int currentPlayer;
    private Instant endTime;
    private Instant startTime;

    /**
     * Default constructor
     */
    public TicTacToe() {
        currentPlayer = 0;
        startTime = Instant.now();
        endTime = Instant.now();
        p1Name = "Player 1";
        p2Name = "Player 2";
        p1Symbol = "X";
        p2Symbol = "O";
        final int size = 3;
        boardSize = size;
        board = new String[size][size];
        turnHistory = new ArrayList<>();
        boardHistory = new ArrayList<>();
    }


    /**
     * Constructor with size parameter
     *
     * @param size Size of board n-by-n
     */
    public TicTacToe(int size) {
        currentPlayer = 0;
        startTime = Instant.now();
        endTime = Instant.now();
        p1Name = "Player 1";
        p2Name = "Player 2";
        p1Symbol = "X";
        p2Symbol = "O";
        boardSize = size;
        board = new String[size][size];
        turnHistory = new ArrayList<>();
        boardHistory = new ArrayList<>();
    }

    /// <summary>
    ///     Constructor with String data parameter
    /// </summary>
    /// <param name="data">Data in format: "P1Name,P2Name,P1Symbol,P2Symbol | StartTime, EndTime | BoardSize | TurnHistory"</param>
    public TicTacToe(String data) {
        currentPlayer = 0;
        String[] dataArray = data.replace(" ", "").split("\\|");
        String[] playerData = dataArray[0].split(",");
        p1Name = playerData[0];
        p2Name = playerData[1];
        p1Symbol = playerData[2];
        p2Symbol = playerData[3];

        String[] timeData = dataArray[1].split(":");
        startTime = Instant.ofEpochMilli(Long.parseLong(timeData[0]));
        endTime = Instant.ofEpochMilli(Long.parseLong(timeData[1]));

        boardSize = Integer.parseInt(dataArray[2]);
        board = new String[boardSize][boardSize];

        turnHistory = List.of(dataArray[3].split(","));
        boardHistory = new ArrayList<>();
        for (String bData : turnHistory) {
            // Format: "Sym-Row-Col"
            String[] bDataArray = bData.split("-");
            board[Integer.parseInt(bDataArray[1])][Integer.parseInt(bDataArray[2])] = bDataArray[0];
            boardHistory.add(board);
        }
    }

    /// <summary>
    ///     Constructor with list of data parameter
    /// </summary>
    /// <param name="dataArray">Data format: "P1Name,P2Name,P1Symbol,P2Symbol | StartTime, EndTime | BoardSize | TurnHistory"</param>
    public TicTacToe(List<String> dataArray) {
        currentPlayer = 0;
        String[] playerData = dataArray.get(0).split(",");
        p1Name = playerData[0];
        p2Name = playerData[1];
        p1Symbol = playerData[2];
        p2Symbol = playerData[3];

        String[] timeData = dataArray.get(0).split(":");
        startTime = Instant.ofEpochMilli(Long.parseLong(timeData[0]));
        endTime = Instant.ofEpochMilli(Long.parseLong(timeData[1]));

        boardSize = Integer.parseInt(dataArray.get(2));

        board = new String[boardSize][boardSize];
        turnHistory = List.of(dataArray.get(3).split(","));
        boardHistory = new ArrayList<>();
        for (String bData : turnHistory) {
            // Format: "Sym-Row-Col"
            String[] bDataArray = bData.split("-");
            board[Integer.parseInt(bDataArray[1])][Integer.parseInt(bDataArray[2])] = bDataArray[0];
            boardHistory.add(board);
        }
    }

    /// <summary>
    ///     Print jagged array as String with each array on a separate line
    ///     Called directly on the boardData array
    /// </summary>
    /// <returns>BoardData Array</returns>
    public String BoardDisplay() {
        return BoardDisplay(board);
    }

    /// <summary>
    ///     Print jagged array as String with each array on a separate line
    ///     Basically java.util.Arrays.deepToString but multi-line
    /// </summary>
    /// <param name="boardData">Jagged String array</param>
    /// <returns>String array</returns>
    public static String BoardDisplay(String[][] boardData) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < boardData.length; i++) {
            for (int j = 0; j < boardData[0].length; j++)
                result.append(boardData[i][j] == null ? "-" : boardData[i][j]).append(" | ");

            result.delete(result.length() - 3, result.length());
            result.append('\n');
        }

        return result.delete(result.length() - 1, result.length()).toString();
    }

    /// <summary>
    ///     Check if move is valid
    /// </summary>
    /// <param name="move">
    ///     Move description in String
    ///     Format: Symbol-Row-Column
    /// </param>
    /// <returns>True if valid</returns>
    public boolean IsValidMove(String move) {
        return IsValidMove(move.split("-"));
    }

    /// <summary>
    ///     Check if move is valid
    /// </summary>
    /// <param name="move">
    ///     Move description in String
    ///     Format: Symbol-Row-Column
    /// </param>
    /// <returns>True if valid</returns>
    public boolean IsValidMove(String[] move) {
        try {
            int row = Integer.parseInt(move[1]);
            int column = Integer.parseInt(move[2]);

            return IsValidMove(row, column);
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    /// <summary>
    ///     Check if move is valid
    /// </summary>
    /// <param name="row">Row of move</param>
    /// <param name="column">Column of move</param>
    /// <returns>True if valid</returns>
    public boolean IsValidMove(int row, int column) {
        return StringUtils.isNotBlank(board[row][column]);
    }

    /**
     * Move symbol to position on board
     *
     * @param row    Row of move
     * @param column Column of move
     * @return True if valid move
     */
    public boolean Move(int row, int column) {
        String symbol = getSymbol(currentPlayer);

        currentPlayer++; // Next player

        return Move(String.join("-", symbol, Integer.toString(row), Integer.toString(column)));
    }

    /**
     * Move symbol to position on board
     *
     * @param moveData Integer array containing position and coordinate
     * @return false if move data is invalid
     */
    public boolean Move(int[] moveData) {
        if (moveData.length == 2)
            return Move(moveData[0], moveData[1]);
        else return false;
    }

    /// <summary>
    ///     Move symbol to position
    /// </summary>
    /// <param name="move">
    ///     Move data
    ///     Format: Symbol-Row-Column
    /// </param>
    /// <returns>True if move is valid</returns>
    public boolean Move(String move) {
        return Move(move.split("-"));
    }

    /// <summary>
    ///     Move symbol to position
    /// </summary>
    /// <param name="move">Move data</param>
    /// <returns>True if move is valid</returns>
    public boolean Move(String[] move) {
        if (!IsValidMove(move) || IsGameOver()) return false;
        String symbol = move[0];
        int row = Integer.parseInt(move[1]);
        int col = Integer.parseInt(move[2]);
        endTime = Instant.now();

        board[row][col] = symbol;
        turnHistory.add(String.join("-", move));
        boardHistory.add(board);
        if (turnHistory.size() == 0)
            startTime = Instant.now();
        endTime = Instant.now();
        return true;
    }

    /// <summary>
    ///     Randomize a move from computer
    /// </summary>
    /// <returns>Integer array representing the coordinate of the move</returns>
    public int[] RandomComputerMoveIntegerArray() {
        if (IsGameOver())
            return new int[]{-1, -1};
        Random r = new Random();
        int row, column;
        do {
            row = r.nextInt(boardSize);
            column = r.nextInt(boardSize);
        } while (!IsValidMove(row, column));

        return new int[]{row, column};
    }

    /// <summary>
    ///     Check if game is over
    /// </summary>
    /// <returns>True if game over</returns>
    public boolean IsGameOver() {
        return !Strings.isNullOrEmpty(GetWinner());
    }

    public String GetWinner() {
        String winner = "";
        if (IsWinner(p1Symbol))
            winner = p1Name;
        else if (IsWinner(p2Symbol))
            winner = p2Name;
        else if (IsFilled())
            winner = "No one";

        return winner;
    }

    /// <summary>
    ///     Check if particular symbol wins
    /// </summary>
    /// <param name="symbol">Symbol needed to check</param>
    /// <returns>True if winner</returns>
    public boolean IsWinner(String symbol) {
        // Check rows
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (!board[i][j].equals(symbol)) break;

                if (j == boardSize - 1) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (!board[j][i].equals(symbol)) break;

                if (j == boardSize - 1) {
                    return true;
                }
            }
        }

        // Check diagonals left to right
        for (int i = 0; i < boardSize; i++) {
            if (!board[i][i].equals(symbol)) break;

            if (i == boardSize - 1) {
                return true;
            }
        }

        // Check diagonals right to left
        for (int i = 0; i < boardSize; i++) {
            if (!board[i][boardSize - 1 - i].equals(symbol)) break;

            if (i == boardSize - 1) {
                return true;
            }
        }

        return false;
    }
    // There is a TicTaxToe.Computer.Minimax.cs file but it is copied code from G4G so it is not suitable for submission

    /// <summary>
    ///     Find the non-empty cells in the board
    /// </summary>
    /// <returns>True if there is no empty cell, false otherwise</returns>
    public boolean IsFilled() {
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                if (board[i][j] == null)
                    return false;
        return true;
    }

    /// <summary>
    ///     Reset the game, but keep the players and symbols
    /// </summary>
    public void Reset() {
        turnHistory.clear();
        board = new String[boardSize][boardSize];
        boardHistory.clear();
        startTime = Instant.now();
        endTime = Instant.now();
    }

    /// <summary>
    ///     Undo last move
    /// </summary>
    /// <param name="row"></param>
    /// <param name="column"></param>
    /// <returns>True if successful</returns>
    public boolean UndoMove(int row, int column) {
        if (row < 0 || row > boardSize || column < 0 || column > boardSize ||
                StringUtils.isBlank(board[row][column]))
            return false;
        board[row][column] = null;
        turnHistory.remove(turnHistory.size() - 1);
        boardHistory.remove(boardHistory.size() - 1);
        return true;
    }

    private String getSymbol(int currentPlayer) {
        switch (currentPlayer % 2) {
            case 0 -> {
                return p1Symbol;
            }
            case 1 -> {
                return p2Symbol;
            }
            default -> {
                return getSymbol(currentPlayer % 2);
            }
        }
    }

    /// <summary>
    ///     Return match data in String
    ///     Format:
    ///     "p1Name,p2Name,p1Symbol,p2Symbol|startTime|endTime|boardSize|turnHistory"
    /// </summary>
    /// <returns>Match data in String</returns>
    @Override
    public String toString() {
        return toStringBuilder().toString();
    }

    /// <summary>
    ///     Return the same String as ToString but in the StringBuilder class
    /// </summary>
    /// <returns></returns>
    public StringBuilder toStringBuilder() {
        return new StringBuilder()
                .append(p1Name).append(',').append(p2Name).append(',')
                .append(p1Symbol).append(',').append(p2Symbol).append('|')
                .append(startTime.toEpochMilli())
                .append(':')
                .append(endTime.toEpochMilli())
                .append('|')
                .append(boardSize).append('|')
                .append(String.join(",", turnHistory));
    }
}
