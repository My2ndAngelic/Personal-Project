package tictactoe.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.commons.text.StringSubstitutor;
import tictactoe.backend.TicTacToe;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class MainWindowController {

    private final int BoardSize = 3;
    private final TicTacToe ttt = new TicTacToe(BoardSize);
    @FXML private ListView<String> listMoveHistory;
    @FXML private GridPane FieldOfPlay;
    @FXML private Label TimeInfo;
    @FXML private Label GameStatus;
    @FXML private Label SysInfo;
    private String folderPath = System.getProperty("user.dir");
    private boolean isComputerTurn = false;
    private boolean isComputerVsComputerMode = false;
    private boolean isComputerVsHumanMode = false;
    private final ObservableList<String> leList = FXCollections.observableArrayList();
    private boolean p1Turn = true;
    public MainWindowController() {

    }

    @FXML
    public void initialize() {
        SysInfo.setText("Save folder: " + folderPath);
        listMoveHistory.setItems(leList);
        initializeBoard();
        listMoveHistory.setCellFactory(cell -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
                    setFont(Font.font(15));
                }
            }
        });
    }

    private void initializeBoard() {
        for (Node node : FieldOfPlay.getChildren()) {
            node.setDisable(false);
            ((Button)node).setText("");
        }

        // Match history list
        CheckGameStatus();
    }

    @FXML
    protected void onButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Button button = (Button) event.getSource();

        int row = GridPane.getRowIndex(node);
        int column = GridPane.getColumnIndex(node);

        if (!ttt.Move(row, column)) // Move method returns false if the move is invalid
            return;

        // Add move history to the list
        leList.add(StringSubstitutor.replace(String.format("${%s} puts ${%s} into row ${row} column ${column}.", p1Turn ? "ttt.p1Name" : "ttt.p2Name", p1Turn ? "ttt.p1Symbol" : "ttt.p2Symbol"), stringsHashMap(row, column)));

        // Color the button
        if (p1Turn)
        {
            button.setText(ttt.getP1Symbol());
            button.setStyle("-fx-text-fill: red");
            p1Turn = false;
        }
        else
        {
            button.setText(ttt.getP2Symbol());
            button.setStyle("-fx-text-fill: blue");
            p1Turn = true;
        }

        // Disable the button
        button.setDisable(true);

        // ListMoveHistory.DataContext.
        CheckGameStatus(); // Check the game status

        // Check if computer vs computer mode
        // If computer vs computer
        if (!isComputerVsComputerMode && !isComputerVsHumanMode)
            return;
        else if (!isComputerVsComputerMode)
            isComputerTurn = !isComputerTurn;
        else
            isComputerTurn = true;

        ComputerMove(); // Computer move
    }

    private void ComputerMove() {
        if (!isComputerTurn || ttt.IsGameOver()) return; // If computer is not playing or game is over, do nothing

        int[] data = ttt.RandomComputerMoveIntegerArray(); // Get computer move
        int row = data[0];
        int column = data[1];
        System.out.println(Arrays.toString(new int[]{row, column}));
//        (FieldOfPlay.getChildren().filtered(x -> GridPane.getRowIndex(x) == row && GridPane.getColumnIndex(x) == column).get(0)).fireEvent(new Event(MouseEvent.MOUSE_CLICKED));
        Button n = new Button();

        for (Node node : FieldOfPlay.getChildren()) {
            if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
                n = (Button) node;
                break;
            }
        }
        n.fire();
    }

    private HashMap<String, String> stringsHashMap() {
        return new HashMap<>() {{
            put("ttt.p1Name", ttt.getP1Name());
            put("ttt.p2Name", ttt.getP2Name());
            put("ttt.p1Symbol", ttt.getP1Symbol());
            put("ttt.p2Symbol", ttt.getP2Symbol());
            put("ttt.winner", ttt.getWinner());
        }};
    }

    private HashMap<String, String> stringsHashMap(int row, int column) {
        return new HashMap<>() {{
           putAll(stringsHashMap());
           put("row", String.valueOf(row));
           put("column", String.valueOf(column));
        }};
    }

    private void CheckGameStatus() {
        if (!ttt.IsGameOver())
        {
            GameStatus.setText(StringSubstitutor.replace("Ongoing between ${ttt.p1Name}: ${ttt.p1Symbol} and ${ttt.p2Name}: ${ttt.p2Symbol}", stringsHashMap()));
            return;
        }

        GameStatus.setText(StringSubstitutor.replace("Game over. ${ttt.winner} wins!", stringsHashMap()));
        // ListMoveHistory.Items.Add($"Match length: {ttt.EndTime.Subtract(ttt.StartTime).TotalSeconds:F} seconds");

        for (Node button : FieldOfPlay.getChildren())
            button.setDisable(true);

        // Auto write to file could be done here
        // Add a checkbox to enable/disable auto-write to file. Maybe implemented in a later version.
        // Not now
    }

    @FXML
    protected void onMenuAboutAction() throws IOException {
        new AboutWindowApplication().start(new Stage());
    }

    @FXML
    protected void onMenuExitAction() {
        System.exit(0);
    }

    @FXML
    protected void onMenuSelectFolderAction(ActionEvent ae) {
//        MenuItem menuItem = (MenuItem) ae.getTarget();
//        ContextMenu menuBar = menuItem.getParentPopup();
//        Scene scene = menuBar.getScene();
//        Window window = scene.getWindow();
        folderPath = new DirectoryChooser().showDialog(((MenuItem) ae.getTarget()).getParentPopup().getScene().getWindow()).getAbsolutePath();
        SysInfo.setText("Save folder: " + folderPath);
    }

    @FXML
    protected void onMenuEvEAction() {
        newGame();
        ttt.setP1Name("Computer 1");
        ttt.setP2Name("Computer 2");
        isComputerVsHumanMode = false;
        isComputerTurn = true;
        isComputerVsComputerMode = true;
        initializeBoard();
        CheckGameStatus();
        ComputerMove();
    }
    @FXML
    protected void onMenuEvPAction() {
        newGame();
        ttt.setP1Name("Computer 1");
        ttt.setP2Name("Player 2");
        isComputerVsHumanMode = true;
        isComputerTurn = true;
        isComputerVsComputerMode = false;
        initializeBoard();
        CheckGameStatus();
        ComputerMove();
    }

    @FXML
    protected void onMenuPvEAction() {
        newGame();
        ttt.setP1Name("Player 1");
        ttt.setP2Name("Computer 2");
        isComputerVsHumanMode = true;
        isComputerTurn = false;
        isComputerVsComputerMode = false;
        initializeBoard();
    }
    @FXML
    protected void onMenuPvPAction() {
        newGame();
        ttt.setP1Name("Player 1");
        ttt.setP2Name("Player 2");
        isComputerVsHumanMode = false;
        isComputerTurn = false;
        isComputerVsComputerMode = false;
        initializeBoard();
    }

    private void newGame() {
        ttt.Reset();
        p1Turn = true;
        leList.clear();
    }

    public void onMenuDebugAction(ActionEvent actionEvent) {

    }
}
