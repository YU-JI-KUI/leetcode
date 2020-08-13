package com.kris.leetcode.easy.array;

/**
 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 5
 Output:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 输出杨辉三角；可用递归或是动态规划，或是直接双层 for 循环。
 *
 * 动态规划的效率更高。
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        List<List<Integer>>  list = p.generate(4);
    }


    /**
     * 更容易理解一点的方式, 双重 for 循环，第一层看行，第二层看列
     *
     * 关键是时间复杂度和空间复杂度和 动态规划一样的。全都是 O(numRows平方)
     */
    public List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < numRows;i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j <= i;j ++){
                if(j == 0 || i == j){
                    list.add(1);
                } else {
                    list.add(result.get(i-1).get(j -1) + result.get(i -1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 动态规划；就是当前数据等于上一行数据相邻两个数据的和，且头和尾都是 1.
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) return triangle;

        // first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int rowNum = 1;rowNum < numRows;rowNum ++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            row.add(1);

            // 第二行这个 for 不会执行
            for(int i = 1;i < rowNum;i ++){
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;

    }



    /**
     * 递归
     *
     * 递归方法总而言之就是抓住三点：
     *
     * 找整个递归的终止条件 : 这里因为比较特殊，第 0 行和第 1 行都是 0，递归向下终止条件可以设置为 numRow = 1;
     * 找返回值 : 这里题目已经给定，返回值是 List<List<Integer>>
     * 一次递归需要如何操作： 找最简单的一级递归，比方说第二行到第三行即可。
     *
     * 有时太迷糊了，目光就盯在一次递归如何操作就行，用具体的数据代入。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dg = new ArrayList<>();
        if(numRows == 0) return dg;

        //递归出口，这是第一步！找到出口
        if(numRows == 1){
            dg.add(new ArrayList<>());
            dg.get(0).add(1);
            return dg;
        }
        //递归，注意返回值！！！这是第二步
        dg = generate(numRows-1);
        //一级递归要做啥，我们可以看第二行到第三行需要做啥
        //首先是要申请一个list来存储第三行，然后通过第二行得到第三行
        //第三行的首尾为1是确定了的，然后就是中间的数如何得到
        //通过观察很容易拿到for循环里面的式子
        //最后别忘了返回值！！！
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int j = 1;j < numRows - 1;j++){
            row.add(dg.get(numRows-2).get(j-1) + dg.get(numRows-2).get(j));
        }
        row.add(1);
        dg.add(row);
        return dg;
    }
}
