public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++){
            res[i] = find(nums, i);
        }
        return res;
    }
    
    private int find(int[] nums,int index){
        for(int i=1;i<=nums.length;i++){
            int help = index+i;
            int next = nums[help%nums.length];
            if(next>nums[index]){
                return next;
            }
        }
        return -1;
    }
}