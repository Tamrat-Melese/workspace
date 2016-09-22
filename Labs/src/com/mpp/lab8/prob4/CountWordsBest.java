package com.mpp.lab8.prob4;

public class CountWordsBest{

    public static void main(String[] args) {
        ICount countWords = (l, c, d, len) -> ((int) l.stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.length() == len && s.contains(("" + c).toLowerCase()) && !s.contains(("" + d).toLowerCase()))
                .count());

        System.out.println(countWords.countWords(CountWordsGood.list, CountWordsGood.c, CountWordsGood.d, CountWordsGood.len));
    }
}
