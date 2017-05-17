/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        int res = 0;
        this.head = head;
        ListNode cur = head ;
        while(cur!= null){
            res++;
            cur = cur.next;
        }
        len = res;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int t = new Random().nextInt(len)+1;
        ListNode cur = head;
        int i=1;
        while(i<t){
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
    
    private int len;
    private ListNode head;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */ 