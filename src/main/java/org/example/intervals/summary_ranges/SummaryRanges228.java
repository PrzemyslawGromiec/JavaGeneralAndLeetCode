package org.example.intervals.summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7, 9, 10};
        int[] edgeValues = {-2147483648, -2147483647, 2147483647};
        List<String> strings = summaryRanges(nums);
        System.out.println(strings);
        System.out.println(summaryRanges(edgeValues));

    }

    /*You are given a sorted unique integer array nums.
Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
*/
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        for (int i = 0, j = 0; j < nums.length; ) {
            if (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            } else {
                if (i != j) {
                    result.add(nums[i] + "->" + nums[j]);
                } else {
                    result.add(String.valueOf(nums[i]));
                }

                i = j + 1;
                j++;
            }
        }
        return result;
    }
}

/*
* [0,1,2,4,5,7]
* nums[j] + 1 == nums[j + 1]
* i = 0 , j = 0, nums.length = 6
* i = 0, nums[0] + 1 == nums[0+1]
* i = 0, 1 == 1 j++, j =1
* i = 1, 2 == 2, j++, j = 2
* i = 2, 3 == 4, false,
* if (2 != 3) {add(nums[i] -> nums[j]
* "0 ->2"
* */

