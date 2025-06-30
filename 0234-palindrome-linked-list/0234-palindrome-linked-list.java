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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true; // if it has only one node - it is palindrome
        ListNode slow=head,fast=head;                   // take two pointers and traver to reach at the middle 
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode firstHalf=head;
        ListNode secondHalf=reverse(slow);              // reverse the second half from the missle & match each node 
        while(secondHalf !=null){
            if(firstHalf.val != secondHalf.val)return false;        // if it does not match - it is not a palindrome 
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){         // helper function to reverse the list 
        ListNode prev=null;     
        ListNode curr=head;
        while(curr !=null ){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}