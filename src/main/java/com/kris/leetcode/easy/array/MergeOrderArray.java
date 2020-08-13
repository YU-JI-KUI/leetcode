package com.kris.leetcode.easy.array;

/**
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
  

 Constraints:

 -10^9 <= nums1[i], nums2[i] <= 10^9
 nums1.length == m + n
 nums2.length == n
 **/

import java.util.Arrays;

/**
 * 合并两个有序数组,做这种题目，一定要画图，其次就是一定要给定具体的 case 去类比，验证。
 * 还要想到用 while. 我发现我就喜欢用 for loop，为不用 while loop.
 */
public class MergeOrderArray {

    /**
     * 双指针：从后往前，利用已经存在的 num1 中的空闲数组，就不需要额外的空间了。
     *
     * 时间复杂度 : O(n + m)
     * 空间复杂度 : O(1)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n -1;

        while(p1 >= 0 && p2 >= 0){
            nums1[p --] = nums1[p1] > nums2[p2] ? nums1[p1 --] : nums2[p2 --];
        }
        // 还有一种可能，就是 p2 还每走完，num2 还有数组没有移过来。因为 p2 走完，则说明 num1 已经被填充完毕。
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1,0 ,p2 + 1);
    }



    /**
     * 双指针：从前往后
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
     *
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     * 所以我们就需要一个长度为 M 的数组存放 num1, 故时间复杂度为 O(m).
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] copy_num1 = new int[m];
        System.arraycopy(nums1,0,copy_num1,0,m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.

//        while ((p1 < m) && (p2 < n))
//            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        while(p1 < m && p2 < n){
            if(copy_num1[p1] < nums2[p2]){
                nums1[p] = copy_num1[p1];
                p ++;
                p1 ++;
            } else {
                nums1[p] = nums2[p2];
                p ++;
                p2 ++;
            }
        }

        // if there are still elements to add
        if(p1 < m)
            System.arraycopy(copy_num1, p1, nums1,p1 + p2, m + n - p2);
        if(p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 最简单的方法，我竟然都每想起来，直接合并之后再排序，但是这种方法没有使用已经是有序数组这个特点
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
