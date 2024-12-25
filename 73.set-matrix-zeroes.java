/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (58.16%)
 * Likes:    15062
 * Dislikes: 768
 * Total Accepted:    1.7M
 * Total Submissions: 3M
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */

import java.util.concurrent.Callable;

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {

        boolean firstRowContainsZero = false;
        boolean firstColContainsZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowContainsZero = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColContainsZero = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowContainsZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColContainsZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        while (true) {
        }
    }
}

// @lc code=end
class MainClass {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        LeetCodeUtils.printMatrix(matrix);
        Callable<Void> job = () -> {
            sol.setZeroes(matrix);
            return null;
        };
        try {
            LeetCodeUtils.runWithTimeout(job, 1);
        } catch (Throwable e) {
            Runtime.getRuntime().exit(1);
        }
        System.out.println("");
        LeetCodeUtils.printMatrix(matrix);
    }
}
