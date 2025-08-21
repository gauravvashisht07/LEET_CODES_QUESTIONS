package com.gaurav;


//https://leetcode.com/problems/two-sum

//---Brute Force Approach
//Logic:
//Check every pair (i, j) in the array.
//If nums[i] + nums[j] == target, return [i, j].

//public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        return new int[] {}; // won't reach here
//    }
//}

//Explanation:
//Outer loop picks the first number.
//Inner loop checks all numbers after it for the complement.
//Time Complexity: O(n²) (nested loop)
//Space Complexity: O(1) (no extra space)

//->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->->


//-----Optimized Approach (HashMap)
//Logic:
//Use a HashMap to store numbers and their indices.
//For each number num, calculate complement = target - num.
//If complement exists in the map → return its index and current index.
// Otherwise, add num to the map.

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // won't reach here
    }
}

