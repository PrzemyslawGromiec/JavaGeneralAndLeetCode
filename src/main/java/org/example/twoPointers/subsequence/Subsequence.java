package org.example.twoPointers.subsequence;

public class Subsequence {
    public static void main(String[] args) {
        String s = "cekl";
        String t = "abcdefkul";
        System.out.println(isSubsequence(s, t));

    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < t.length()) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;
        }
        return false;
    }
}
