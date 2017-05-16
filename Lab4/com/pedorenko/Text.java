package com.pedorenko;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by andrew on 12.05.17.
 */
public class Text {
    private ArrayList<Sentence> text = new ArrayList<>();

    public Text(String text) {
        int beg = 0;
        int end;

        for (int i = 0; i < text.length(); ++i) {

            /*Deleting extra spaces*/
            if ((text.charAt(i) == ' ') && (i + 1 < text.length())
                    && (text.charAt(i + 1) == ' ')) {
                StringBuilder sb = new StringBuilder(text);
                sb.deleteCharAt(i);
                text = sb.toString();
                --i;
                continue;
            }

            /*Separating sentences*/
            if ((text.charAt(i) == '.') || (text.charAt(i) == '!') || (text.charAt(i) == '?')) {
                end = i + 1;
                String sentence = text.substring(beg, end);
                this.text.add(new Sentence(sentence));
                beg = i + 1;
            }
        }
    }

    public HashSet<String> getSetOfWords() {
        HashSet<String> words = new HashSet<>();

        for (Sentence sentence : text) {
            words.addAll(sentence.getSetOfWords());
        }
        return words;
    }

    public ArrayList<Sentence> getSentences(){
        return text;
    }
}
