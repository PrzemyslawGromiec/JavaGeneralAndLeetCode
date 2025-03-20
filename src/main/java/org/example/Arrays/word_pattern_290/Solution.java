package org.example.Arrays.word_pattern_290;

import java.util.HashMap;

public class Solution {
    /*
     * Given a pattern and a string s, find if s follows the same pattern.
     * Each letter in pattern maps to exactly one unique word in s.
     * Each unique word in s maps to exactly one letter in pattern.
     * No two letters map to the same word, and no two words map to the same letter.
     */
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWordMap = new HashMap<>();
        HashMap<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWordMap.containsKey(ch)) {
                if (!charToWordMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(ch, word);
            }
            if (wordToCharMap.containsKey(word)) {
                if (wordToCharMap.get(word) != ch) {
                    return false;
                }
            } else {
                wordToCharMap.put(word, ch);
            }
        }
        return true;
    }
}