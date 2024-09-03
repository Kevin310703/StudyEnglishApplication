package com.uet.studyenglishapplication.game;

import com.uet.studyenglishapplication.game.modelview.LetterLabel;
import com.uet.studyenglishapplication.game.modelview.LetterStyle;
import com.uet.studyenglishapplication.ui.controller.Application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

public class HowToController {

    @FXML
    private TilePane tilepane1;
    @FXML
    private TilePane tilepane2;
    @FXML
    private TilePane tilepane3;
//    @FXML
//    private Label replayLabel;
//    @FXML
//    private Button switchButton;
    
    public void initialize() {
//        replayLabel.setText(new String(Character.toChars(Integer.parseInt("F0459", 16))));
//        replayLabel.setStyle("-fx-font-family: \"Material Design Icons\"; -fx-font-size: 28");
//        switchButton.setText(new String(Character.toChars(Integer.parseInt("F0156", 16))));
//        switchButton.setStyle("-fx-font-family: \"Material Design Icons\"; -fx-font-size: 28");
        
        LetterLabel ll = (LetterLabel)tilepane1.getChildren().get(0);
        ll.setLetterDisplay(LetterStyle.DisplayType.MATCHING);
        ll = (LetterLabel)tilepane2.getChildren().get(1);
        ll.setLetterDisplay(LetterStyle.DisplayType.PARTIALMATCH);
        ll = (LetterLabel)tilepane3.getChildren().get(3);
        ll.setLetterDisplay(LetterStyle.DisplayType.NOMATCH);
        
    }

    @FXML
    private void switchToWordish() throws IOException {
        Application.setRoot("wordish");
    }
}
