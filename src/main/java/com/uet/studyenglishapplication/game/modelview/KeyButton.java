package com.uet.studyenglishapplication.game.modelview;

import static com.uet.studyenglishapplication.game.modelview.LetterStyle.DisplayType.*;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.MATCHING_PSEUDO_CLASS;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.NOMATCH_PSEUDO_CLASS;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.PARTIALMATCH_PSEUDO_CLASS;
import static com.uet.studyenglishapplication.game.modelview.LetterStyle.PLAIN_PSEUDO_CLASS;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;

public class KeyButton extends Button {

    public KeyButton() {
        super();
        getStyleClass().add("matching-letter");
        getStyleClass().add("nomatch-letter");
        getStyleClass().add("partialmatch-letter");
        getStyleClass().add("plain-letter");
    }
    
    private final ObjectProperty<LetterStyle.DisplayType> letterDisplay = new SimpleObjectProperty<LetterStyle.DisplayType>(PLAIN) {
        @Override
        public void invalidated() {
            // Turn off all of the custom PseudoClasses in the LetterLabel, 
            // and then uses a switch statement to turn on a 
            // specific PseudoClass depending on the value 
            // in the labelDisplay property
            pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, false);
            pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, false);
            LetterStyle.DisplayType displayType = get();
            if (displayType == PLAIN) {
                pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, true);
            } else if (displayType == NOMATCH) {
                pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, true);
            } else if (displayType == PARTIALMATCH) {
                pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, true);
            } else if (displayType == MATCHING) {
                pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, true);
            } else {
                pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, true);
            }
        }
    };
    
    public void setLetterDisplay(LetterStyle.DisplayType labelType) {
        // this invokes invalidated()
        this.letterDisplay.set(labelType);
    }

    public LetterStyle.DisplayType getLetterDisplay() {
        return letterDisplay.get();
    }
    

}
