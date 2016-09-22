package com.mpp.lab8.prob4;

import java.util.List;

@FunctionalInterface
public interface ICount {
    int countWords(List<String> words, char c, char d, int len);
}
