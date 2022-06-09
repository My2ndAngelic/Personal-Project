package tictactoe.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class MainWindowController {

    @FXML
    protected void onButtonClick(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
    }

    @SneakyThrows
    @FXML
    protected void onMenuAboutAction() {
        new AboutWindowApplication().start(new Stage());
    }

    @FXML
    protected void onMenuExitClick() {
        Platform.exit();
        System.exit(0);
    }
}
