package org.example.intervals.insert_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval57 {

    /*
    * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]],
    * newInterval = [4,8]
    * Output: [[1,2],[3,10],[12,16]]*/


//    intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {3,5}, {6,7}, {8,10}, {12,16} };
        int[] newInterval = {4,8};
        int[][] mergedIntervals = insert(intervals,newInterval);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

       // Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedList = new ArrayList<>(Arrays.asList(intervals));

        mergedList.add(newInterval);

        mergedList.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] prev = mergedList.getFirst();

        for(int i = 1; i < mergedList.size(); i++) {
            int[] current = mergedList.get(i);

            if (current[0] <= prev[1]) {
                prev[1] = Math.max(current[1],prev[1]);
            } else {
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);

    }

}
