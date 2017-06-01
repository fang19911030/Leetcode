public class Solution {
    public void rotate(int[] nums, int k) {
        if(k<0){
            return;
        }
        k = k%nums.length;
        int l1 = 0;
        int r1 = l1+(nums.length-k)-1;
        int l2 = r1+1;
        int r2 = nums.length-1;
        subrotate(nums,l1,r1);
        subrotate(nums,l2,r2);
        subrotate(nums,l1,r2);
        
    }
    
    private void subrotate(int[]nums, int l, int r){
        while(l<r && r<nums.length){
            swap(nums,l++,r--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}