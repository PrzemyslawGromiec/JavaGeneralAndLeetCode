package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeInterval {
    public static void main(String[] args) {
        // Example input: [[7,7],[2,3],[6,11],[1,2]]
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(List.of(7, 7)));
        intervals.add(new ArrayList<>(List.of(2, 3)));
        intervals.add(new ArrayList<>(List.of(6, 11)));
        intervals.add(new ArrayList<>(List.of(1, 2)));

        // Call the method and print the result
        List<List<Integer>> mergedIntervals = getMergedIntervals(intervals);

        // Output the result
        for (List<Integer> interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }

        intervals.sort(Comparator.comparing(List::getFirst));
        List<List<Integer>> mergedIntervals = new ArrayList<>();

        List<Integer> currentInterval = intervals.getFirst();
        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> nextInterval = intervals.get(i);
            if (currentInterval.get(1) >= nextInterval.get(0)) {
                currentInterval.set(1,Math.max(currentInterval.get(1),nextInterval.get(1)));
            } else {
                mergedIntervals.add(new ArrayList<>(currentInterval));
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(new ArrayList<>(currentInterval));
        return mergedIntervals;
    }

}
