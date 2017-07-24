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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode solution = new ListNode(Integer.MIN_VALUE);
        ListNode cur = solution;
        int addOne = 0;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                int res = l1.val + l2.val + addOne;
                addOne = res / 10;
                ListNode next = new ListNode(res % 10);
                cur.next = next;
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null){
                int res = l1.val + addOne;
                ListNode next = new ListNode(res % 10);
                addOne = res / 10;
                cur.next = next;
                cur = cur.next;
                l1 = l1.next;
            } else {
                int res = l2.val + addOne;
                ListNode next = new ListNode(res % 10);
                addOne = res / 10;
                cur.next = next;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (addOne == 1) {
            cur.next = new ListNode(1);
        }
        return solution.next;
    }
}