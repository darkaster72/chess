module io.github.darkaster.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.kordamp.ikonli.fontawesome;
    requires java.desktop;

    opens io.github.darkaster.chess to javafx.fxml;
    exports io.github.darkaster.chess;
}