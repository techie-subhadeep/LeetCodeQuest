/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (55.84%)
 * Likes:    11206
 * Dislikes: 598
 * Total Accepted:    950K
 * Total Submissions: 1.7M
 * Testcase Example:  '"ABAB"\n2'
 *
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you
 * can get after performing the above operations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * 
 * 
 */
// class Solution424 {
// @lc code=start
class Solution {
    int highestFreqArr(int[] arr) {
        int maxFreq = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxFreq) {
                maxFreq = arr[i];
            }
        }
        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxValidWindowSize = 0;
        int[] windowCharFreq = new int[26];

        while (right < s.length()) {
            windowCharFreq[s.charAt(right) - 'A']++;
            while (!((right - left + 1) - highestFreqArr(windowCharFreq) <= k) && left < right) {
                windowCharFreq[s.charAt(left) - 'A']--;
                left++;
            }
            // Valid Window
            maxValidWindowSize = Math.max(maxValidWindowSize, right - left + 1);
            right++;
        }
        return maxValidWindowSize;
    }
}
// @lc code=end

class MainClass424 {
    public static void main(String[] args) {
        // Solution424 solution = new Solution424();
        // var res = solution.characterReplacement(
        // "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF",
        // 4);
        // System.out.println(res);
    }
}
