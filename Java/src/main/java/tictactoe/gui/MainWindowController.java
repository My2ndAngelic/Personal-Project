package tictactoe.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainWindowController {

    @FXML
    protected void onButtonClick(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
    }

    @FXML
    protected void onMenuNewClick() {

    }

    @FXML
    protected void onMenuExitClick() {
        Platform.exit();
        System.exit(0);
    }
}
