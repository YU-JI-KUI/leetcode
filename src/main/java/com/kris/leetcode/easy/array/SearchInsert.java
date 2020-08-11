package com.kris.leetcode.easy.array;

/**
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 **/

/**
 * 看到有序，就应该想到二分法，O(n) 时间复杂度并不是最好的。还有二分法的log n
 *
 * 二分法不会写，想不到用 while，也想不到 while 的结束条件，结束条件就是没有查到，直接返回 length 了。
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = new int[]{1,3,5,6};
        searchInsert.searchInsert(nums, 7);
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 第一想法，几分钟就实现了，还可以优化，因为有序，可以使用二分法查找
     */
    public int searchInsert(int[] nums, int target) {
        int j = 0;
        for(int i = 0;i < nums.length;i ++){
            if(nums[i] >= target){
                return i;
            }
            if(nums[i] < target){
                j ++;
            }
        }
        return j;
    }
}
