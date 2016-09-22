package com.mpp.lab8.prob4;

import java.util.ArrayList;
import java.util.List;

public class CountWordsGood implements ICount {

    public static List<String> list = setList();
    private static List<String> setList(){
        List<String> l = new ArrayList<>();
        l.add("abcd");
        l.add("bcde");
        l.add("cdef");
        l.add("defg");
        return l;
    }
    public static int len = 4;
    public static char c = 'c';
    public static char d = 'f';

    public static void main(String[] args) {

        CountWordsGood good = new CountWordsGood();
        System.out.println(good.countWords(list, c, d, len));
    }

    @Override
    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.length() == len && s.contains(("" + c).toLowerCase()) && !s.contains(("" + d).toLowerCase()))
                .count();
    }
}
