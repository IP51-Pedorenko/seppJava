package com.pedorenko;

import java.util.*;

/**
 * Created by andrew on 12.05.17.
 */
public class Lab4 {
    public static void main(String [] args){
        int max = 0;
        String requestedWord = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text:");
        Text text = new Text(scan.nextLine());
        HashSet<String> allWords = text.getSetOfWords();

        /*Checks for each word in text in how many sentences it appears*/
        for (String word : allWords) {
            int k = 0;
            for (Sentence sentence : text.getSentences()) {
                for (String sentenceWord : sentence.getSetOfWords()) {
                    if (word.equals(sentenceWord)){
                        ++k;
                        break;
                    }
                }
            }
            if (max < k){
                max = k;
                requestedWord = word;
            }
        }

        System.out.println("Number of needed sentences: " + max);
        System.out.println("Requested word: " + requestedWord);
    }
}
