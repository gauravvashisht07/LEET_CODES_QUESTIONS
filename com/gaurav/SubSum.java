package com.gaurav;
//https://leetcode.com/problems/subarray-sum-equals-k
public class SubSum {
    //Brute Force
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //Optimized
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int prefixSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // accounts for subarray starting at index 0

            for (int num : nums) {
                prefixSum += num;
                count += map.getOrDefault(prefixSum - k, 0);
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            }
            return count;
        }
    }

}
