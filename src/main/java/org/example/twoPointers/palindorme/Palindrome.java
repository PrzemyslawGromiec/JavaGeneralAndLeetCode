package org.example.twoPointers.palindorme;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("mamam"));
        System.out.println(isPalindrome("dad"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int sLen = s.length();
        int index = 0;

        while (index < sLen / 2) {
            char p1 = s.charAt(index);
            char p2 = s.charAt(sLen - 1 - index);

            if (p1 != p2) {
                return false;
            }
            index++;
        }
        return true;
    }


    public boolean isPalindrome2(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        String cleanedStr = cleaned.toString();
        String reversedStr = cleaned.reverse().toString();

        return cleanedStr.equals(reversedStr);
    }
}
