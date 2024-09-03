package com.uet.studyenglishapplication.game.service;

import com.uet.studyenglishapplication.StudyEnglishApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class WordData {
    
    private static WordData instance = null;

    private String theWord = "";
    private final Set<Integer> usedIndices = new HashSet<>();
    private List<String> words;
    private final Random rand = new Random();

    private WordData() {
        try (InputStream is = StudyEnglishApplication.class.getResourceAsStream("/com/uet/studyenglishapplication/service/wordlist.txt")) {
            if (is == null) {
                System.out.println("null");
            }
            assert is != null;
            words = new BufferedReader(
                    new InputStreamReader(is))
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
    }
    
    public static WordData getInstance() {
        if (instance == null) {
            instance = new WordData();
        }
        return instance;
    }

    public String getTheWord() {
        return theWord;
    }
    
    public boolean isAWord(String guess) {
        return words.stream().anyMatch(w -> w.equals(guess));
    }

    int index;
    public void setNewWord() {   
        do {
            index = rand.nextInt(words.size());
        } while (!usedIndices.add(index));

        theWord = words.get(index);
        System.out.println("theWord = " + theWord);
    }

}
