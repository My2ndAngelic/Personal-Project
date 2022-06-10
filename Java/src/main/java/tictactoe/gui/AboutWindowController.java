package tictactoe.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AboutWindowController {


    @FXML
    public void onButtonOKClick(MouseEvent mouseEvent) {
        ((Stage)(((Button)mouseEvent.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private TextArea taAbout;
    @FXML
    private TextField tfTitle;

    @FXML
    public void initialize() {
        taAbout.setText(new AboutWindowData().gettAbout());
        tfTitle.setText(new AboutWindowData().getTTitle());
    }
}
