public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] heap = new int[nums.length];
        String[] res = new String[nums.length];
        Map<Integer,String> rank = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            heapInsert(heap, i,nums[i]);
        }
        /*test*/
//        for(int i=0;i<heap.length;i++){
//            System.out.print(heap[i]);
//        }
        int heapzie = heap.length;
        for(int i=heapzie-1;i>0;i--) {
            swap(heap, 0, i);
            heapzie--;
            heapify(heap, 0, heapzie);
        }
//        for(int i=0;i<heap.length;i++){
//            System.out.print(heap[i]+" ");
//        }
        for(int i=0;i<heap.length;i++){
            if(i==0){
                rank.put(heap[i],"Gold Medal");
            }
            if(i==1){
                rank.put(heap[i],"Silver Medal");
            }
            if(i==2){
                rank.put(heap[i],"Bronze Medal");
            }
            if(i>=3) {
                String tmp = String.valueOf(i + 1);
                rank.put(heap[i], tmp);
            }
        }
        for(int i=0;i<res.length;i++){
            res[i] = rank.get(nums[i]);
        }

        return res;


    }

    private void heapInsert(int[]heap, int index, int num){
        heap[index] = num;
        while(index>0){
            int parent = (index-1)/2;
            if(heap[parent]>heap[index]){
                swap(heap,index,parent);
            }else{
                break;
            }
            index = parent;
        }
    }

    private void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void heapify(int[] heap, int index,int heapzie){
        int left = 2*index +1;
        int right = 2*index+2;
        int smallest = index;
        while(left<heapzie){
            if(heap[left]<heap[smallest]){
                smallest = left;
            }
            if (right < heapzie && heap[right]<heap[smallest]){
                smallest = right;
            }
            if(smallest != index){
                swap(heap,smallest,index);
            }else{
                break;
            }
            index = smallest;
            left = 2*index+1;
            right = 2*index+2;
        }
    }
}