package org.example.intervals.insert_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervalsAnotherSolution {
    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {3,5}, {6,7}, {8,10}, {12,16} };
        int[] newInterval = {4,8};

        int[][] merged = insertInterval(intervals,newInterval);
        for (int[] ints : merged) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        int n = existingIntervals.length;

        List<int[]> output = new ArrayList<>();

        while (i < n && existingIntervals[i][0] < newStart) {
            output.add(existingIntervals[i]);
            i += 1;
        }

        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            output.getLast()[1] = Math.max(output.getLast()[1],newEnd);
        }

        while (i < n) {
            int[] existingInterval = existingIntervals[i];
            int start = existingInterval[0];
            int end = existingInterval[1];
            if (output.getLast()[1] < start) {
                output.add(existingInterval);
            } else {
                output.getLast()[1] = Math.max(output.getLast()[1], end);
            }
            i += 1;
        }
        return output.toArray(new int[0][0]);
    }


}
