/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
          @Override
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, cmp);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(pq.size()>0){
            ListNode minimum = pq.poll();
            ListNode next = null;
            if(minimum.next!= null){
                next = minimum.next;
                minimum.next=null;
            }
            cur.next = minimum;
            cur = cur.next;
            if(next!= null){
                pq.add(next);
            }

        }
        return res.next;
    }
}