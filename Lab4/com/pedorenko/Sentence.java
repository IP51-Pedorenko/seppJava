package com.pedorenko;

import java.util.*;

/**
 * Created by andrew on 12.05.17.
 */
public class Sentence {
    private ArrayList<SentencePart> sentence = new ArrayList<>();

    Sentence(String sentence) {
        int i = 0;

        while (i < sentence.length()) {
            StringBuilder word = new StringBuilder();

            /*Separates words*/
            while (Character.isLetter(sentence.charAt(i))){
                word.append(sentence.charAt(i));
                if (i + 1 < sentence.length()){
                    ++i;
                }
            }

            /*Adds word to sentence*/
            if (!word.toString().equals("")){
                this.sentence.add(new Word(word.toString()));
            }

            /*Adds punctuation*/
            if (i < sentence.length()){
                this.sentence.add(new Punctuation(sentence.charAt(i)));
            }

            ++i;
        }
    }

    public HashSet<String> getSetOfWords(){
        HashSet<String> words = new HashSet<>();

        for (SentencePart part : sentence) {

            /*Checks if it is a Word NOT Punctuation*/
            if (part.getClass().toString().equals("class com.pedorenko.Word")) {
                words.add(part.toString().toLowerCase());
            }
        }
        return words;
    }
}
