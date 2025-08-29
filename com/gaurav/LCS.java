package com.gaurav;
import java.util.*;
//https://leetcode.com/problems/longest-consecutive-sequence
public class LCS {
    //Brute Force
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1, current = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;  // skip duplicates
            } else if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        longest = Math.max(longest, current);
        return longest;
    }



    //Optimized
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {  // start of sequence
                int current = num + 1;
                while (set.contains(current)) {
                    current++;
                }
                longest = Math.max(longest, current - num);
            }
        }
        return longest;
    }

}
