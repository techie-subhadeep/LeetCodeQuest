
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (35.85%)
 * Likes:    40858
 * Dislikes: 1971
 * Total Accepted:    6.7M
 * Total Submissions: 18.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */
import java.util.*;
// @lc code=start

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPosMap = new HashMap<>();
        int lenSubstr = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int prevSPos = charPosMap.getOrDefault(s.charAt(right), -1);
            if (prevSPos >= left) {
                left = prevSPos + 1;
            }
            charPosMap.put(s.charAt(right), right);
            // The window is valid now
            lenSubstr = Math.max(lenSubstr, right - left + 1);
            right++;
        }
        return lenSubstr;
    }
}
// @lc code=end
