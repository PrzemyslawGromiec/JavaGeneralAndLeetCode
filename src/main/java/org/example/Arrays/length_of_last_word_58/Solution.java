package org.example.Arrays.length_of_last_word_58;

public class Solution {
    public static void main(String[] args) {
        String s = "  Hello world  ";
        System.out.println(lengthOfLastWord(s));
        String r = "   hello4, sdff , egiso5";
        System.out.println(lengthOfLastWordExcludingSpecialCharacters(r));

    }

    public static int lengthOfLastWord(String s) {
//        if (s == null || s.isEmpty()) return 0;
//
//        String[] words = s.trim().split("\\s+");
//        return words[words.length - 1].length();

        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        System.out.println(s);

        int lastSpaceIndex = s.lastIndexOf(' ');
        System.out.println(s.charAt(lastSpaceIndex + 1));
        String lastWord = s.substring(lastSpaceIndex + 1);
        System.out.println(lastWord);
        return lastWord.length();
    }

    public static int lengthOfLastWordExcludingSpecialCharacters(String s) {
        if (s == null || s.isEmpty()) return 0;

        s = s.replaceAll("^a-zA-Z ]", "");

        s = s.trim();

        int lastSpaceIndex = s.lastIndexOf(' ');
        String lastWord = s.substring(lastSpaceIndex + 1);
        System.out.println(lastWord);

        return lastWord.length();
    }
}
