package org.example.SlidingWindow.minimumSizeSubarraySum209;

import java.util.Arrays;

public class Solution {
    /*
    * nums - array of positive integers
    * target - positive integer
    * return min length of subarray whose sum is greater or equal to target
    * example: nums = {2,3,1,2,4,3}, target = 7 -> output = 2 as subarray is {4,3}
    * */

    /*
    * 1. array can be length of 1
    * 2. they both can start at the same point
    * 3. we can move first and second index*/
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int winStart = 0, sum = 0;
        int minLength = Integer.MAX_VALUE; // Track the smallest subarray length

        for (int winEnd = 0; winEnd < nums.length; winEnd++) {
            System.out.println("Iteration nr: " + winEnd);
            sum += nums[winEnd];  // Expand the window by adding nums[winEnd]
            System.out.println("current sum: " + sum);

            // Shrink the window as much as possible while sum is still >= target
            while (sum >= target) {
                System.out.println("sum >= target");
                System.out.println("current winEnd:" + winEnd);
                System.out.println("current winStart:" + winStart);
                minLength = Math.min(minLength, winEnd - winStart + 1);
                System.out.println("minLenght is: " + minLength);
                sum -= nums[winStart];  // Remove leftmost element to shrink window
                System.out.println("Removing element at index: " + winStart
                + " and it's value is: " + nums[winStart]);
                System.out.println("Current sum is: " + sum);
                winStart++;  // Move the window start forward
                System.out.println("updated winStart is:" + winStart);
            }
        }

        // If minLength was not updated, return 0 (no valid subarray found)
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static int minSubArrayLen2(int target, int[] nums) {

        int n = nums.length;
        int left=0, sum=0;
        int count = 0;
        int arraylen = Integer.MAX_VALUE;

        for (int right=0; right<n; right++){
            sum += nums[right];
            while (sum>=target){
                //System.out.println("sum:right:left "+ sum + " " + "  " + right + "  " + left);
                arraylen = Math.min(arraylen, right-left+1);
                sum = sum - nums[left];
                left++;

            }

        }

        if (arraylen == Integer.MAX_VALUE) return 0;
        return arraylen;



    }
}
