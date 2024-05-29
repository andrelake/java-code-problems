package com.andrelake.javacodeproblems.chapter1;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseWords {

    private static final Pattern PATTERN = Pattern.compile(" +");
    private static final String WHITESPACE = " ";

    public static String reverseWords(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new RuntimeException("Input cannot be null or empty");
        }

        return PATTERN.splitAsStream(input)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }

    public static String reverseWordsV1(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new RuntimeException("Input cannot be null or empty");
        }

        String[] words = input.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        var result = reverseWordsV1("Hello");
        System.out.println(result);
    }
}
