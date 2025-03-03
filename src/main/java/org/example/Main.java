package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Hello world", "FlatMap is powerful", "Java streams");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream()
                .flatMap(n -> {
                    if (n % 2 == 0) {
                        return Stream.of(n, n + 10);
                    } else {
                        return Stream.of(n, n + 100);
                    }
                })
                .toList();

        System.out.println(result);


        Map<String, List<String>> products = new HashMap<>();
        products.put("Fruits", Arrays.asList("Apple", "Banana", "Orange"));
        products.put("Veg", Arrays.asList("Carrot", "Potato", "Tomato"));

        List<String> resProd = products.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(resProd);

        //teeing can apply two separate collectors and join the result
        Stream<Integer> nums = Stream.of(1, 2, 3, 4);
        Map<String, Integer> collect = nums.collect(Collectors.teeing(
                Collectors.maxBy(Integer::compareTo),
                Collectors.minBy(Integer::compareTo),
                (e1, e2) -> Map.of("min", e1.get(), "max", e2.get())
        ));

        System.out.println(collect);

        Map<Boolean, List<String>> parioningList = Stream.of("apple", "banana", "orange", "grape")
                .collect(Collectors.partitioningBy(f -> f.length() > 5));

        System.out.println(parioningList);

        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);

        // Obliczamy średnią arytmetyczną i sumę liczb
        double average = numbers2.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Integer::doubleValue), // Sumowanie liczb (jako double)
                        Collectors.counting(), // Zliczanie liczb
                        (sum, count) -> sum / count // Obliczenie średniej arytmetycznej
                ));

        System.out.println(average + " average");
    }


}