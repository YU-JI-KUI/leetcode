package com.kris.leetcode.easy.array;

/**
 Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example 1:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.

 It doesn't matter what you leave beyond the returned length.
 Example 2:

 Given nums = [0,1,2,2,3,0,4,2], val = 2,

 Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

 Note that the order of those five elements can be arbitrary.

 It doesn't matter what values are set beyond the returned length.
 Clarification:

 Confused why the returned value is an integer but your answer is an array?

 Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

 Internally you can think of this:

 // nums is passed in by reference. (i.e., without making a copy)
 int len = removeElement(nums, val);

 // any modification to nums in your function would be known by the caller.
 // using the length returned by your function, it prints the first len elements.
 for (int i = 0; i < len; i++) {
     print(nums[i]);
 }
 **/

/**
 * 看到空间复杂度是能是 O(1), 我就立马想到了 “双指针法”，第一次觉得刷题这么有意思。
 *
 * 时间复杂度为 O(n), 空间复杂度为 O(1), 这算法也是没谁了。必须为自己点赞
 *
 * 但是，还是可以优化的！
 * Tips:
 * 尝试双指针法。
 * 你是否使用“元素顺序可以更改”这一属性？
 * 当要删除的元素很少时会发生什么？
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[] {0,1,2,2,3,0,4,2};
        removeElement.removeElement(nums, 2);

        int[] nums2 = new int[] {0,1,2,2,3,0,4,2,5};
        removeElement.removeElement2(nums2, 5);

        int[] nums3 = new int[] {8,0,1,2,2,3,0,4,2,5};
        removeElement.removeElement2(nums3, 8);
    }

    /**
     * 要删除的数据很少的时候用这种方法更快。因为数组的移动只有相同的时候才会发生。
     * 每移动一次数组，就代表删除一个数据。n -- , 最后剩的就是不重复的长度。
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] == val){
                nums[i] = nums[n -1];
                // reduce array size by one
                n --;
            } else {
                i ++;
            }
        }
        return n;
    }

    /**
     * 时间复杂度：O(n)，
     * 假设数组总共有 n 个元素，i 和 j 至少遍历 2n 步。
     *
     * 空间复杂度：O(1)。
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j < nums.length;j ++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
