package org.example.Arrays.longest_common_prefix_14;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /*  Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".
    */

    public static void main(String[] args) {
        String[] sortedArray = {"flower","flow","flight"};
        String[] array2 = {"aaa","aa","aaa"};
        String commonPrefix = longestCommonPrefix(sortedArray);
        System.out.println("Longest Common Prefix: " + commonPrefix);
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(array2));

        System.out.println("Longest with nested for: " + longestCommonUsingNestedFor(sortedArray));
    }

    public static String longestCommonPrefix(String[] strs) {

//        Arrays.sort(sortedArray, (str1, str2) -> Integer.compare(str2.length(), str1.length()));


        if (strs == null || strs.length == 0) {
            return "";
        }

        // ["flower", "flow", "flight"]
        String shortest = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        return Arrays.stream(strs)
                .reduce(shortest, (prefix, str) -> {
                    while (!str.startsWith(prefix)) {
                        prefix = prefix.substring(0,prefix.length()-1);
                    }
                    return prefix;
                });
    }

    public static String longestCommonUsingNestedFor(String[] elements) {
        if (elements.length == 0) {
            return "";
        }

        String shortest = Arrays.stream(elements)
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        for (int i = 0; i < shortest.length(); i++) {
            for (String element : elements) {
                if (element.charAt(i) != shortest.charAt(i)) {
                    return shortest.substring(0,i);
                }
            }
        }
        return shortest;
    }

    /* if (strs.length == 0) {
            return "";
        }
        String[] sortedArray = Arrays.copyOf(strs,strs.length);
        Arrays.sort(sortedArray);
        String first = sortedArray[0];
        String last = sortedArray[sortedArray.length-1];
        int i = 0;
        while (i < first.length() && i < last.length() &&
                first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0,i);*/
}
