package com.andrelake.javacodeproblems.chapter1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateChars {

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }


    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }


    public static void main(String[] args) {
        String str = "banana";
        System.out.println(countDuplicateCharactersV1(str));
        System.out.println(countDuplicateCharactersV2(str));
    }
}

