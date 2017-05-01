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
        if(headA == null || headB == null ){
            return null;
        }
        int lengthA = Length(headA);
        int lengthB = Length(headB);
        ListNode longer = lengthA>=lengthB? headA:headB;
        ListNode shorter = lengthA<lengthB? headA:headB;
        int diff = Math.abs(lengthA-lengthB);
        while(diff>0){
            if(longer != shorter){
                longer = longer.next;
                diff--;
            }else{
                return longer;
            } 
        }
        while(longer!= null){
            if(longer != shorter){
                longer = longer.next;
                shorter = shorter.next;
            }else{
                return longer;
            }
        }
        return null;
    }
    
    public int Length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}