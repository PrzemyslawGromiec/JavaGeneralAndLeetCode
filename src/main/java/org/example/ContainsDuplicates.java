package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicated(nums));
        System.out.println(containsDuplicated(nums2));

    }

    /*
     * Given an integer array nums, return true if any value appears
     * at least twice in the array, and return false if every element is distinct.
     * nums = [1,2,3,1] true
     * nums = [1,2,3,4] false
     * */

    public static boolean containsDuplicated(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int c : nums) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (int v : counts.values()) {
            if (v >= 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicated2(int[] nums) {
        HashSet<Integer> seenNum = new HashSet<>();
        for (int num : nums) {
            if (seenNum.contains(num)) {
                return true;
            }
            seenNum.add(num);
        }
        return false;
    }

    public static boolean containsDuplicated3(int[] nums) {
        Set<Integer> setValues = new HashSet<>();
        for (int num : nums) {
            if (!setValues.add(num)) {
                return true;
            }
        }
        return false;

    }
}
