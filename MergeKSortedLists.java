/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int heapsize;
    private ListNode[] A;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists== null|| lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        int heapsize = 0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!= null){
                heapsize++;
            }
        }
        A = new ListNode[heapsize];
        int index = 0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!= null){
                A[index++] = lists[i];
            }
        }
        for(int i=heapsize/2;i>=0;i--){
            minHeapify(A,i);
        }
        if(heapsize == 0){
            return null;
        }
        ListNode res = A[0];
        if(A[0].next!= null){
            A[0] = A[0].next;
            minHeapify(A,0);
        }else{
            heapsize--;
            minHeapify(A,0);
        }
        ListNode cur = res;
        while(heapsize>=1){
            cur.next = A[0];
            if(A[0].next!= null){
                A[0] = A[0].next;
                minHeapify(A,0);
            }else{
                heapsize--;
                minHeapify(A,0);
            }
            cur = cur.next;
        }
        return res;
        
    }
    
    private void minHeapify(ListNode[]A, int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int small = i;
        while(left<heapsize){
            if(A[left].val<A[small].val){
                small = left;
            }
            if(right<heapsize & A[right].val<A[small].val){
                small = right;
            }
            if(small != i){
                swap(A, i, small);
            }
            i = small;
            left = 2*i+1;
            right = 2*i+2;
        }
    }
    
    private void swap(ListNode[]A, int i, int j){
        ListNode tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}