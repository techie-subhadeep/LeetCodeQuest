/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (63.63%)
 * Likes:    33002
 * Dislikes: 558
 * Total Accepted:    2.5M
 * Total Submissions: 3.9M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int[] lrMax = new int[height.length];
        int[] rlMax = new int[height.length];
        int waterTrapped = 0;
        int acc = -1;
        for (int i = 0; i < height.length; i++) {
            acc = Math.max(acc, height[i]);
            lrMax[i] = acc;
        }

        acc = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            acc = Math.max(acc, height[i]);
            rlMax[i] = acc;
        }

        for (int i = 0; i < height.length; i++) {
            waterTrapped += Math.min(lrMax[i], rlMax[i]) - height[i];
        }

        return waterTrapped;
    }
}
// @lc code=end
