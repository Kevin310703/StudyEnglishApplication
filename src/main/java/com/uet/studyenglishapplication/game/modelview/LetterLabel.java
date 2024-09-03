package com.uet.studyenglishapplication.game.modelview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

import static com.uet.studyenglishapplication.game.modelview.LetterStyle.*;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.DisplayType.DISPLAYING;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.DisplayType.PLAIN;

public class LetterLabel extends Label {

    public LetterLabel() {
        super();
        getStyleClass().add("displaying-letter");
        getStyleClass().add("matching-letter");
        getStyleClass().add("nomatch-letter");
        getStyleClass().add("partialmatch-letter");
        getStyleClass().add("plain-letter");
    }
    
    private final ObjectProperty<LetterStyle.DisplayType> matchResult = new SimpleObjectProperty<>(DISPLAYING);
    private final ObjectProperty<LetterStyle.DisplayType> letterDisplay = new SimpleObjectProperty<>(PLAIN) {
        @Override
        public void invalidated() {
            // Turn off all the custom PseudoClasses in the LetterLabel,
            // and then uses a switch statement to turn on a 
            // specific PseudoClass depending on the value 
            // in the letterDisplay property
            pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, false);
            pseudoClassStateChanged(DISPLAYING_PSEUDO_CLASS, false);
            pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, false);
            switch (get()) {
                case PLAIN -> pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, true);
                case DISPLAYING -> pseudoClassStateChanged(DISPLAYING_PSEUDO_CLASS, true);
                case NOMATCH -> pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, true);
                case PARTIALMATCH -> pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, true);
                case MATCHING -> pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, true);
            }
        }
    };
    
    public void setLetterDisplay(DisplayType labelType) {
        this.letterDisplay.set(labelType);
    }
    public DisplayType getLetterDisplay() {
        return letterDisplay.get();
    }
    
    public void setMatchResult(DisplayType labelType) {
        this.matchResult.set(labelType);
    }
    public DisplayType getMatchResult() {
        return matchResult.get();
    }

}
