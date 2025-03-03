package org.example.twoPointers.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 1};
        int[] nums2 = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums2));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));


        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;

                } else {
                    high--;
                }
            }
        }
        return result;
    }


}
