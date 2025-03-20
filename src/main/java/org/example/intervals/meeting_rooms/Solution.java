package org.example.intervals.meeting_rooms;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{0,4},{5,10},{15,20}};
        int[][] intervals3 = {{}};
        int[][] intervals4 = {};
        System.out.println(canAttendMeetings(intervals));
        System.out.println(canAttendMeetings(intervals2));
        System.out.println(canAttendMeetings(intervals3));
        System.out.println(canAttendMeetings(intervals4));

    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return false;
        }
        //sort intervals
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int[] interval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if (interval[1] > intervals[i][0]) {
                return false;
            }
            interval = intervals[i];
        }
        return true;
    }

    public boolean canAttendMeetings2(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
