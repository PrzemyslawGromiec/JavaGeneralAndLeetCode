package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        //System.out.println(isAnagram(s, t));
        countCharactersInWord(s);
        //System.out.println(isAnagram2(s, t));


    }

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }

    public static void countCharactersInWord(String word) {
        int[] letterCounts = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c >= 'a' && c <= 'z') {
                letterCounts[c- 'a']++;
            }
        }

        for (int i =0; i < letterCounts.length;i++) {
            if (letterCounts[i] > 0) {
                System.out.println((char) (i + 'a') + " : " + letterCounts[i]);
            }
        }
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
