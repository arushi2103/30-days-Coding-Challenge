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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //first move one poiter by n steps - now start moving both pointers by 1 steps ---> at the end the second pointer will be       n steps behind the 1st pointer - now remove the nth node and return the head node 

        ListNode temp=new ListNode(0,head);
        ListNode fast=temp;
        ListNode slow=temp;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return temp.next;
        
    }
}