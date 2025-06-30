/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current=head;
        while(current != null){
            ListNode nextNode=current.next; //store next node
            current.next=prev;              //reverse link
            prev=current;                   //move 1 step and make current as prev
            current=nextNode;               //and make next as current 

        }
        return prev;
    }
}