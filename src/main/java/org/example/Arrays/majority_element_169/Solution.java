package org.example.Arrays.majority_element_169;

import java.util.HashMap;

public class Solution {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majorityThreshold = nums.length / 2; // Element musi wystąpić więcej niż n / 2 razy

        for (int num : nums) {
            // Zwiększ licznik dla bieżącego elementu
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Sprawdź, czy liczba osiągnęła próg większości
            if (countMap.get(num) > majorityThreshold) {
                return num; // Zwróć element, gdy znajdziesz większość
            }
        }

        // Gwarancja zadania mówi, że większość zawsze istnieje, więc ten punkt nigdy nie zostanie osiągnięty
        throw new IllegalArgumentException("No majority element found.");
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println("Majority Element: " + majorityElement(nums)); // Output: 3
    }
}
