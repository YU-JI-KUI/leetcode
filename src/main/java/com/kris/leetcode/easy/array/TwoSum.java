package com.kris.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 **/

/**
 * 每给出一种算法就要考虑时间复杂度，和空间复杂度。
 *
 * 我们给出算法之后就要想到，要用时间换空间，还是空间换时间
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        twoSum.twoSum1(nums, target);
        twoSum.twoSum2(nums, target);
    }

    /**
     * 时间复杂度：n
     * 空间复杂度：n
     *
     * 使用 Map （哈希表） 来用空间换时间
     *
     * map 的 key 和 value 怎么存？这就需要好好看看怎么才能得到下标
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 时间复杂度：n平方
     * 空间复杂度：1
     *
     * 可优化的方面，时间太长，需要用空间换时间
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0;i < nums.length - 1;i ++){
            for(int j = i + 1;j < nums.length;j ++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
