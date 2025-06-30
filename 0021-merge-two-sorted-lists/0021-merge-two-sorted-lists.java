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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode dummy=new ListNode(0);
        ListNode tail =dummy;

        while(list1!=null && list2 != null){
            if(list1.val <= list2.val){
                tail.next=list1;    //add this node from list1 to tail
                list1=list1.next;   //move to next pointer
            }else{
                tail.next=list2;    //same
                list2=list2.next;
            }
            tail=tail.next;         // move to last node of tail to process further
        }
        //one of the list is null at this point - add remaining in the tail
        if(list1 != null){
            tail.next=list1;
        }else{
            tail.next=list2;
        }
        return dummy.next;
    }
}