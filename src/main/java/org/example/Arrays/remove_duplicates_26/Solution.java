package org.example.Arrays.remove_duplicates_26;

/*Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the
number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted,
you need to do the following things:
Change the array nums such that the first k elements of nums contain
the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.*/

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;

        for(int fast = 1; fast< nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
