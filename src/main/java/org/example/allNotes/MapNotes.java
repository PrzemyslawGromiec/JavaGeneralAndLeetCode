package org.example.allNotes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapNotes {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cat", "banana", "apple");
//        System.out.println(wordFrequency(words));

        wordFrequency(words).forEach((word, count) ->
                System.out.println(word + ": " + count));

        wordFrequency(words).forEach((word, count) ->
                System.out.printf("Word '%s' occurs %d times%n",
                        word, count));

        wordFrequency(words).entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue()));

        wordsByLength(words);
        concatenateByWordsLength(words);
    }


    public static Map<String, Long> wordFrequency(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static Map<Integer, List<String>> wordsByLength(List<String> words) {
        Map<Integer, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(String::length));

        result.forEach((length, group) ->
                System.out.println("Length " + length + ": " + group)
        );

        return result;
    }

    public static Map<Integer, String> concatenateByWordsLength(List<String> words) {
        Map<Integer, String> result = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.joining(", "))
                ));

        result.forEach((length, concatenated) ->
                System.out.println("Length: " + length + ": " + concatenated));

        return result;
    }
}
