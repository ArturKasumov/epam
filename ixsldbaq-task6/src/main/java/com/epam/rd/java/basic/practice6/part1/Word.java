package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

    private String content;

    private int frequency;

    public Word(String s, int i) {
        content = s;
        frequency = i;
    }

    @Override
    public String toString() {
        return content + " : " + frequency;
    }

    @Override
    public int compareTo(Word o) {
        return o.content.compareTo(this.content);
    }
    public int compareTo2(Word o) {
        return (o.frequency)-(this.frequency);
    }

    @Override
    public int hashCode() {
        return 38*content.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Word otherWord = (Word) obj;
        return otherWord.content.equals(content);
    }

    public void increaseFrequency() {
        ++frequency;
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return -frequency;
    }

    public int alphabet(Word another) {
        int len1 = content.length();
        int len2 = another.content.length();
        int lim = Math.min(len1, len2);
        char[] v1 = content.toCharArray();
        char[] v2 = another.content.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return -c1 + c2;
            }
            k++;
        }
        return -len1 + len2;
    }

}
