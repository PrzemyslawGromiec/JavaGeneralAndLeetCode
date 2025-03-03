package org.example.Arrays.product_of_array_except_self;

import java.util.Arrays;

public class Solution {
    /*
    * compute new array answer[] where each element at index i should be the product of all elements
    * of nums except nums[i]
    * nums = [1, 2, 3, 4]
    * answer[0] = 2 * 3 * 4 = 24
    * answer[1] = 1 * 3 * 4 = 12
    * answer[2] = 1 * 2 * 4 = 8
    * answer[3] = 1 * 2 * 3 = 6
    * answer = [24, 12, 8, 6]
    *
    * answer[i] = (product of all elements before `i`) * (product of all elements after `i`)
     */

    public static void main(String[] args) {
        int[] nums2 = {0,2,3};
        int[] nums3 = {2,2,2,2};
        int[] nums4 = {5};

        int[] nums = {1, 2, 3, 4};  // Example input
        System.out.println("Input array: " + Arrays.toString(nums));
        int[] answer = productExceptSelf(nums);
        System.out.println("Final result: " + Arrays.toString(answer));

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        // Step 1: Compute prefix products
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(result) + " - prefix array");

        // Step 2: Compute suffix products while updating result
        int[] suf = new int[n];  // Array to store suffix values
        int suffix = 1;  // Start suffix as 1 (no elements after last index)

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suffix;
            result[i] *= suffix;
            suffix *= nums[i];  // Update suffix product
        }

        System.out.println(Arrays.toString(suf) + " - suffix array");
        return result;
    }
}
