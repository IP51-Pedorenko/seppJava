package com.pedorenko;

import java.util.*;

/**
 * Created by andrew on 12.05.17.
 */

/**
 * Lab 3 makes set of all word in input text.
 * After that it check's for each word in set, in
 * how many sentences is appears. The max amount
 * of the sentences and the word, that repeats in
 * them are printed in console.
 */
public class Lab3 {
    public static void main(String [] args){
        int max = 0;
        String text = new String();
        String sent = new String();
        String repeatedWord = new String();
        ArrayList<String> words = new ArrayList<>();
        HashSet<String> allWords = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your text:");
        text = scanner.nextLine();

        /*makes set of all words*/
        words.addAll(Arrays.asList(text.split("\\W+")));
        for (ListIterator<String> i = words.listIterator();i.hasNext();) {
            i.set(i.next().toLowerCase());
        }
        allWords.addAll(words);
        words.clear();

        /*checks for each word how many sentences have it*/
        for (String word : allWords) {
            int beg = 0;
            int end;
            int k = 0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.') {
                    end = i;
                    sent = text.substring(beg, end);
                    words.addAll(Arrays.asList(sent.split("\\W+")));

                    for (String sentWord : words) {
                        if (word.equals(sentWord.toLowerCase())) {
                            ++k;
                            break;
                        }
                    }
                    words.clear();
                    beg = end + 1;
                }
            }
            if (max < k) {
                max = k;
                repeatedWord = word;
            }
        }

        System.out.println("Number of needed sentences: " + max);
        System.out.println("Repeated word: " + repeatedWord);
    }
}
