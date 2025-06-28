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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=new ListNode(0,head);
        ListNode fast=temp,slow=temp,left=temp;
        for(int i=1;i<=k;i++){
            fast=fast.next;
            left=left.next;
        }
        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }
        int val = slow.val;
        slow.val=left.val;
        left.val=val;

        return temp.next;
    }
}

//here i used 3 pointers 
// fast and left pointer to reach kth node from first 
//then move fast and slow by one step till slow reached to kth from last 
//now left is at kth from 1st and slow is at kth from last 
// swap values from both and return head