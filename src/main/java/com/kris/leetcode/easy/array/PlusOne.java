package com.kris.leetcode.easy.array;

/**
 Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 **/

/**
 * 这一题就是简单的找规律，没有什么奇特的方法。
 * 每一个元素加一只有两种可能，要么就是等于 10 赋值为 0，要么就是加一直接返回。
 * 只有一种特殊 case, 所有元素都是 999，则需要增加一位长度，第一位是 1，其余都是 0。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1;i >= 0;i --){
            digits[i] ++;
            if(digits[i] == 10){
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
