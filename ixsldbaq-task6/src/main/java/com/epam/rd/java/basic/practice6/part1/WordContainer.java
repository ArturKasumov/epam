package com.epam.rd.java.basic.practice6.part1;

import java.util.*;
import java.util.stream.Collectors;

public class WordContainer {

    private static Set<Word> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            if (!s.equals("stop")) {
                if (s.contains("stop")) {
                    s = s.substring(0, s.indexOf("stop"));
                }
                String[] arr = s.split("\\s+");
                for (String s1 : arr)
                    addWord(s1);

            }
        }
        List<Word> l = set.stream()
                .sorted(Comparator.comparing(Word::getFrequency).thenComparing(Word::getContent))
                .collect(Collectors.toList());
        Iterator<Word> i = l.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        set.clear();
    }

    public static void addWord(String s) {
        Word currentWord = null;
        boolean flag = false;
        if (set.isEmpty())
            set.add(new Word(s, 1));
        else {
            for (Word word : set) {
                if (word.getContent().equals(s)) {
                    flag = true;
                    currentWord = word;
                    break;
                }
            }
            if (!flag)
                set.add(new Word(s, 1));
            if (flag) {
                currentWord.increaseFrequency();
            }
        }
    }
    public static String print() {
        StringBuilder sb = new StringBuilder();
        List<Word> l = set.stream()
                .sorted(Comparator.comparing(Word::getFrequency).thenComparing(Word::getContent))
                .collect(Collectors.toList());
        Iterator<Word> i = l.iterator();
        while (i.hasNext())
            sb.append(i.next());
        return sb.toString();
    }


}
