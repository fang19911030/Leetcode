public class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            pq2.add(nums[i]);
        }
        int j = nums.length%2==0? 2:1;
        for(int i=nums.length-j;i>=0;i-=2){
            nums[i] = pq.poll();
        }
        for(int i=1;i<nums.length;i+=2){
            nums[i] = pq2.poll();
        }
        
    }

    //we can find the median number of this array to solve this problem
}