package com.uet.studyenglishapplication.game.modelview;

import com.uet.studyenglishapplication.StudyEnglishApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class WordPopup {
    
    private static final int POPUP_TIMEOUT = 2500;

        private static Popup createPopup(final String message) {
            final Popup popup = new Popup();
            popup.setAutoFix(true);
            Label label = new Label(message);
            label.getStylesheets().add(Objects.requireNonNull(StudyEnglishApplication.class.getResource("/com/uet/studyenglishapplication/css/SceneGame.css")).toExternalForm());
            label.getStyleClass().add("popup");
            popup.getContent().add(label);
            return popup;
        }

        public static void show(final String message, final Control control) {
            Stage stage = (Stage) control.getScene().getWindow();
            final Popup popup = createPopup(message);
            popup.setOnShown(e -> {
                popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
                popup.setY(stage.getY() + stage.getHeight() / 3 - (popup.getHeight()/2) - 10 );
            });
            popup.show(stage);

            new Timeline(new KeyFrame(
                    Duration.millis(POPUP_TIMEOUT),
                    ae -> popup.hide())).play();
        }
    
}
