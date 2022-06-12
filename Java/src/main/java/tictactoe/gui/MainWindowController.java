package tictactoe.gui;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import tictactoe.backend.TicTacToe;

import java.io.IOException;

public class MainWindowController {

    private final int BoardSize = 3;
    private final TicTacToe ttt = new TicTacToe(BoardSize);
    private String folderPath = System.getProperty("user.dir");
    private boolean isComputerTurn = false;
    private boolean isComputerVsComputerMode = false;
    private boolean isComputerVsHumanMode = false;
    private final ObservableList<String> leList = new MainWindowData().getTListMoveHistory();
    private boolean p1Turn = true;

    @FXML
    protected void onButtonClick(MouseEvent event) {
        Node node = (Node) event.getSource();
        Button btn = (Button) event.getSource();

        int row = GridPane.getRowIndex(node);
        int column = GridPane.getColumnIndex(node);
        btn.setText("Button ID: " + row + ", " + column);
    }

//    @FXML
//    protected void onButtonAction(ActionEvent event) {
//        var node = (Node) event.getSource();
//        var btn = (Button) event.getSource();
//
//        Object row = GridPane.getRowIndex(node);
//        Object column = GridPane.getColumnIndex(node);
//        btn.setText("Button ID: " + row + ", " + column);
//    }

    @FXML
    protected void onMenuAboutAction() throws IOException {
        new AboutWindowApplication().start(new Stage());
    }

    @FXML
    protected void onMenuExitClick() {
        new Alert(Alert.AlertType.ERROR) {{
            setTitle("Exit");
            setTitle("Message Here...");
            setHeaderText("Look, an Information Dialog");
            setContentText("I have a great message for you!");
            showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }};

        Platform.exit();
        System.exit(0);
    }

    public void onMenuSelectFolderAction(ActionEvent ae) {
//        MenuItem menuItem = (MenuItem) ae.getTarget();
//        ContextMenu menuBar = menuItem.getParentPopup();
//        Scene scene = menuBar.getScene();
//        Window window = scene.getWindow();
        try {
            folderPath = new DirectoryChooser().showDialog(((MenuItem) ae.getTarget()).getParentPopup().getScene().getWindow()).getAbsolutePath();
            System.out.println(folderPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
