package com.pedorenko;

import java.util.ArrayList;

/**
 * Created by andrew on 12.05.17.
 */
public class Word extends SentencePart{
    private ArrayList<Letter> word = new ArrayList<>();

    Word(String word){
        for (int i = 0; i < word.length(); ++i) {
            Letter letter = new Letter(word.charAt(i));
            this.word.add(letter);
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder();

        for (Letter letter : word) {
            str.append(letter.getLetter());
        }
        return str.toString();
    }
}
