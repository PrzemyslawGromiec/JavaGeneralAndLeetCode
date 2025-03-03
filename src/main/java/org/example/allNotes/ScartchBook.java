package org.example.allNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScartchBook {

    /*
    Count how many times a specific character appears across
     a list of strings using reduce.
    */


    public static void main(String[] args) {
        String[] words = {"apple", "banana", "grape", "pineapple"};
        char target = 'a';
        System.out.println("Occurrence of: " + target + " : " +
                countCharOccurrence(words,target));

        char[] all = new char[Arrays.stream(words).mapToInt(String::length).sum()];
        int index = 0;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                all[index++] = c;
            }
        }

        List<String> longWords = Arrays.stream(words)
                        .filter(word -> word.length() > 6)
                                .toList();

        List<String> longWords2 = Arrays.stream(words).parallel()
                .filter(w -> w.length() > 6)
                .collect(ArrayList::new, List::add,List::addAll);

        for (String longWord : longWords) {
            System.out.println(longWord);
        }

        for (String s : longWords2) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(all));
        System.out.println("Using stream: " + Arrays.toString(getAllWordsAsChars(words)));

    }

    public static int countCharOccurrence(String[] array, char target){
        return Arrays.stream(array)
                .reduce(0, (sum, word) -> sum + (int) word.chars()
                        .filter(ch -> ch == target).count(), Integer::sum);
    }

    public static char[] getAllWordsAsChars(String[] words) {
        return Arrays.stream(words)
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString()
                .toCharArray();
    }




}
