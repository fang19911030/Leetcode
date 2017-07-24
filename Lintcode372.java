/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node.next == null){
            node = null;
            return;
        } else{
            ListNode pre = null;
            while(node.next != null){
                pre = node;
                node.val = node.next.val;
                node = node.next;
            }
            pre.next = null;
        }
    }
}