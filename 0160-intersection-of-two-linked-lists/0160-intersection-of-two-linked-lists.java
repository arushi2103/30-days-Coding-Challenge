/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while(headA != null){
            if(!set.contains(headA))set.add(headA);
            else return headA; // if already contains the node it means it has been traversed already - intersection point 
            headA=headA.next;
        }
        while(headB!=null){
            if(!set.contains(headB))set.add(headB);
            else return headB;
            headB=headB.next;
        }

        return null; // it there was intersection it would have been return already during traversal 
    }
}