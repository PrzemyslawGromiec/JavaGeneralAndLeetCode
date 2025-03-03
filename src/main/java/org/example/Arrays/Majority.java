package org.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Majority {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,1,1,2,2};
        int[] nums1 = new int[]{2,4,5,9,0,10,3,12,6};
//        System.out.println(majorityElement(nums));
        int target = 10;
//        calculateTwoSum(nums1,target);

        int[] nums2 = {3, 5, 2, 8, 15, 7, 11, 1, 2, 8};
        int target2 = 10;

        List<int[]> pairs = allPairsUsingHashMap(nums2, target2);
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));


    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int threshold = nums.length/2;

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
            if (countMap.get(num) > threshold) {
                return num;
            }
        }
        throw new IllegalArgumentException("No majority element found.");
    }

    public static int[] calculateTwoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] nums1 = new int[]{2,4,5,9,0,10,3,12,6};
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println("Index: " + i + ", Value: " + nums[i] + ", Complement: " + complement);

            if(map.containsKey(complement)) {
                System.out.println("Found: Complement " + complement + " for nums[" + i + "] in map.");
                return new int[]{map.get(complement),i};
            }
            System.out.println("Adding nums[" + i + "] = " + nums[i] + " to map.");
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static List<int[]> allPairsUsingHashMap(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result.add(new int[]{map.get(complement), i});
            }

            map.put(nums[i],i );

        }
        return result;
    }



}
