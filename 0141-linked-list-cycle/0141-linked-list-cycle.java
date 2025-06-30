/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        // Base case: if the list is empty or has only one node, it can't have a cycle
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false; // If fast pointer reaches the end, there is no cycle
            slow = slow.next;                                        // Move slow by one step
            fast = fast.next.next;                                   // Move fast by two steps
        }

        // If slow and fast meet, a cycle exists
        return true;
    }
}
