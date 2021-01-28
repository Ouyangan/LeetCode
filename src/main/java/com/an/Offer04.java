package com.an;

/**
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //校验参数
        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0].length == 0) {
            return false;
        }
        //行数
        int rows = matrix.length;
        //列数
        int columns = matrix[0].length;
        //
        int cellRow = 0;
        int cellColumn = columns - 1;
        while (cellRow < rows && cellColumn >= 0) {
            int cellVal = matrix[cellRow][cellColumn];
            if (cellVal == target) {
                return true;
            }
            if (cellVal < target) {
                cellRow++;
            } else {
                cellColumn--;
            }
        }
        return false;
    }
}
