
/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (51.57%)
 * Likes:    12558
 * Dislikes: 345
 * Total Accepted:    953.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 * 
 * 
 */
import java.util.*;

// class Solution438 {
// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] refFreq = new int[26];
        int[] windowFreq = new int[26];
        List<Integer> sols = new ArrayList<>();
        int left = 0;
        int right = 0;
        int pLen = p.length();
        int sLen = s.length();

        for (int i = 0; i < p.length(); i++) {
            refFreq[p.charAt(i) - 'a']++;
        }

        while (right < sLen) {
            windowFreq[s.charAt(right) - 'a']++;
            if (right - left + 1 == pLen) {
                if (Arrays.equals(windowFreq, refFreq)) {
                    sols.add(left);
                }
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return sols;
    }
}

// @lc code=end
class MainClass438 {
    public static void main(String[] args) {
        // Solution438 sol = new Solution438();
        // var result = sol.findAnagrams("cbaebabacd", "abc");
        // System.out.println(result);
    }
}