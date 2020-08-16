package com.kris.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

 Note that the row index starts from 0.

 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 3
 Output: [1,3,3,1]
 Follow up:

 Could you optimize your algorithm to use only O(k) extra space ?
 **/

/**
 * 两种算法：第一种是有数学公式，可以直接计算出第 n 行的数据。
 * 第二种就是真正的算法了
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        List<Integer> list = pascalsTriangleII.getRow2(5);
        list.forEach(li -> System.out.print(li));
    }

    /**
     * 1、没想到是先处理行尾，
     * 2、没想到是倒着修改值，
     *
     * 因为每一行的dp[i]是取决于上一行的 j 位置和 j-1 位置，如果不倒着更新，在下一个j+1位置的时候，计算的 j - 1 已经被改过了，就错了。
     * 1        0
     * 11       1
     * 121      2
     * 1331     3
     * 14641    4
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        while(rowIndex -- >= 0){
            list.add(1);
            for(int i = list.size() - 2;i > 0;i --){
                list.set(i, list.get(i) + list.get(i -1));
            }
        }
        return list;
    }

    /**
     * 行数从 0 开始，所以长度要 row + 1
     *
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
