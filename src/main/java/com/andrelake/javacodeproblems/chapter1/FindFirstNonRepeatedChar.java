package com.andrelake.javacodeproblems.chapter1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class FindFirstNonRepeatedChar {

    public static char firstNonRepeatedCharacter(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }

        //linkedHashMap to maintain order
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars.compute(ch, (k, v) -> (Objects.isNull(v)) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String str = "banana";
        System.out.println(firstNonRepeatedCharacter(str));
    }
}
