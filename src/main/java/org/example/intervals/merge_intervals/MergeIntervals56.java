package org.example.intervals.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},{2, 6},{8, 10},{15, 18}};
        int[][] result = merge(intervals);
        // Wyświetlenie wyniku za pomocą Arrays.deepToString
        System.out.println(Arrays.deepToString(result));
    }

    /*
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    */

    public static int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> results = new ArrayList<>();

        for(int[] interval: intervals){
            if(results.isEmpty()){
                results.add(interval);
            } else if(results.getLast()[1] < interval[0]) {
                results.add(interval);
            } else {
                results.getLast()[1] = Math.max(results.getLast()[1], interval[1]);
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
