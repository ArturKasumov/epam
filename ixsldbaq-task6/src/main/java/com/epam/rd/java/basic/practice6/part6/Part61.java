package com.epam.rd.java.basic.practice6.part6;


import com.epam.rd.java.basic.practice6.part1.Word;

import java.util.*;

public class Part61 {
    public static Word[] getWords() {
        return words;
    }

    private static Word[] words;

    public static void main(String[] args) {
        String s = args[0];
        String[] a = s.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(a));
        String[] unique = uniqueWords.toArray(new String[0]);
        words = new Word[uniqueWords.size()];
        for (int i = 0; i < unique.length; ++i) {
            int res = 0;
            res = countOccurences(a, unique[i]);
            words[i] = new Word(unique[i], res);
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (-(words[j].getFrequency()) > -(words[j + 1].getFrequency())) {
                    Word tmp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (-(words[j].getFrequency()) == -(words[j + 1].getFrequency())) {
                    int c = 0;
                    for (int h = 0; h < a.length; ++h) {
                        if (words[j].getContent().equals(a[h])) {
                            c = h;
                            break;
                        }
                    }
                    int d = 0;
                    for (int e = 0; e < a.length; ++e) {
                        if (words[j+1].getContent().equals(a[e])) {
                            d = e;
                            break;
                        }
                    }
                    if (c > d) {
                        Word tmp = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = tmp;
                    }
                }
            }
        }
        Arrays.sort(words, Word::compareTo2);
        Word[] res = new Word[3];
        for (int i = 0; i < 3; ++i) {
            res[i] = words[i];
        }

        Arrays.sort(res, Word::alphabet);
        for (Word w : res) {
            System.out.println(w.getContent()+" ==> "+-(w.getFrequency()));
        }
    }

    static int countOccurences(String[] str, String word) {
        String[] a = str;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (word.equals(a[i]))
                count++;
        }
        return count;
    }
}