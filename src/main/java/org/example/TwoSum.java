package org.example;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0,7,11,20,23,3,4,5,6,7,8,202,12,13,15,1,2};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSu2m(nums,target)).forEach(System.out::println);
        System.out.println();
//        Optional<int[]> result = twoSum3(nums, target);
//        result.ifPresentOrElse(
//                indices -> System.out.println("Found: " + Arrays.toString(indices)),
//                () -> System.out.println("No solution found.")
//        );

        List<int[]> pairs = allPairsUsingHashMap(nums, target);
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println("Index: " + i + ", Value: " + nums[i] + ", Complement: " + complement);

            if (map.containsKey(complement)) {
                System.out.println("Found: Complement " + complement + " for nums[" + i + "] in map.");
                return new int[]{map.get(complement), i};
            }

            System.out.println("Adding nums[" + i + "] = " + nums[i] + " to map.");
            map.put(nums[i], i);
        }
        System.out.println("No solution found.");
        return null;
    }


    public static int[] twoSu2m(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Checking: nums[" + i + "] + nums[" + j + "] = "
                        + nums[i] + " + " + nums[j] + " = " + (nums[i] + nums[j]));
                if (nums[i] + nums[j] == target) {
                    System.out.println("Found: nums[" + i + "] + nums[" + j + "] = " + target);
                    return new int[]{i, j};
                }
            }
        }
        System.out.println("No solution found.");
        return null;
    }

    public static Optional<int[]> twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return Optional.of(new int[]{i, j}); // Return the result wrapped in Optional
                }
            }
        }
        return Optional.empty(); // Return an empty Optional if no solution
    }

    public static List<int[]> allPairsUsingHashMap(int[] nums, int target) {
        List<int[]> result = new ArrayList<>(); // To store all pairs
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // Add the pair to the result
                result.add(new int[]{map.get(complement), i});
            }
            // Add the current number to the map
            map.put(nums[i], i);
        }

        return result;
    }

}
