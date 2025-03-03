package org.example.Arrays.majority_element_169;

public class MajorityBoyerAlgorithm {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 1, 1, 2, 2};
        int[] nums = {2, 2, 1, 4, 5,2,2};
        try {
            System.out.println("Majority Element: " + majorityElement(nums));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int majorityElement(int[] nums) {
        //Phase 1: candidate selection
        int candidate = nums[0];
        int count = 0;
        System.out.println("Candidate selection: ");
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                System.out.println("Count is 0. Setting candidate to: " + candidate);
            }
            count += (num == candidate) ? 1 : -1;
            System.out.println("Processing num: " + num + ", Current candidate: " + candidate + ", Count: " + count);
        }
        //Phase 2: verification
        System.out.println("\nPhase 2: Verification");
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
            System.out.println("Counting candidate: " + candidate + ", Current num: " + num + ", Count: " + count);
        }
        if (count > nums.length / 2) {
            System.out.println("Candidate " + candidate + " verified as majority with count: " + count);
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found.");
        }
    }

}
