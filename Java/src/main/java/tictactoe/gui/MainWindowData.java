package tictactoe.gui;

import javafx.collections.ObservableList;
import lombok.Data;
import lombok.Getter;

public @Data class MainWindowData {
    private @Getter ObservableList<String> TListMoveHistory;
}
