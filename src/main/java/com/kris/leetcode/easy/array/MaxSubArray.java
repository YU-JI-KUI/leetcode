package com.kris.leetcode.easy.array;

/**
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 **/

/**
 * 求最大子序和
 *
 * 算法一： 贪心算法：若当前指针所指元素,之前元素的和小于0，则丢弃当前元素之前的数列。
 *
 * 算法二： 动态规划：
 *
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray.maxSubArray(nums);
    }

    /**
     * 贪心算法实现，若当前指针所指元素之前的元素的和小于0，则丢弃当前元素之前的数列。丢弃也就是代表将 sum 置为 0 。
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if(sum < 0){
                sum = 0;
            }
            sum = sum + num;
            max = Math.max(sum, max);
        }
        return max;
    }
}
