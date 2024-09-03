module com.uet.studyenglishapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.materialdesign2;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jlayer;
    requires org.jsoup;

    opens com.uet.studyenglishapplication to javafx.fxml;
    opens com.uet.studyenglishapplication.ui.controller to javafx.fxml;
    opens com.uet.studyenglishapplication.game to javafx.fxml;
    opens com.uet.studyenglishapplication.game.modelview to javafx.fxml;
    exports com.uet.studyenglishapplication;
    exports com.uet.studyenglishapplication.server;
}