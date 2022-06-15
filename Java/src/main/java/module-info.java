module me.my2ndangelic {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.apache.commons.lang3;
    requires org.apache.commons.text;
    requires com.google.common;
    requires lombok;
    requires annotations;

    opens tictactoe.gui to javafx.fxml;
    exports tictactoe.gui;
}