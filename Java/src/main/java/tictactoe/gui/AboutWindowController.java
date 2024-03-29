package tictactoe.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AboutWindowController {
    @FXML
    private Label tfTitle;
    @FXML
    private Label taAbout;

    @FXML
    private void onButtonOKClick(MouseEvent mouseEvent) {
        ((Stage) (((Button) mouseEvent.getSource()).getScene().getWindow())).close();
    }

    @FXML
    public void initialize() {
        tfTitle.setText(AboutWindowData.tTitle());
        taAbout.setText(AboutWindowData.tAbout());
    }
}
