/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (47.40%)
 * Likes:    19382
 * Dislikes: 829
 * Total Accepted:    3.1M
 * Total Submissions: 6.6M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 */

// @lc code=start

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode anchor = new ListNode();
        anchor.next = head;
        ListNode leadingPointer = head;
        ListNode trailingPointer = anchor;

        while (leadingPointer != null && n > 0) {
            leadingPointer = leadingPointer.next;
            n--;
        }
        if (n > 0) {
            // n elements are not present
            // return head without deletion
            return head;
        }

        while (leadingPointer != null) {
            leadingPointer = leadingPointer.next;
            trailingPointer = trailingPointer.next;
        }
        trailingPointer.next = trailingPointer.next.next;
        return anchor.next;
    }
}

// @lc code=end
class MainClass {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> valList = Arrays.asList(1, 2, 3, 4, 5);
        ListNode head = LeetCodeUtils.listToListNode(valList);
        LeetCodeUtils.printListNode(head);
        System.out.println("Program END");
        // LeetCodeUtils.runWithTimeout(() -> sol.removeNthFromEnd(head, 2), 500);
        sol.removeNthFromEnd(head, 2);
        LeetCodeUtils.printListNode(head);
    }
}