public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==1){
            return;
        }
        if(isDes(nums)){
            Arrays.sort(nums);
            return;
        }
        int right = nums.length-1;
        int i,j;
        for(i=right;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }
        int small = i;
        for(j=right;j>=i;j--){
            if(nums[j]>nums[i-1] && nums[j]<=nums[small] ){
                small = j;
            }
        }
        
        int tmp = nums[i-1];
        nums[i-1] = nums[small];
        nums[small] = tmp;
        Arrays.sort(nums,i,nums.length);
    }
    
    public boolean isDes(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                return false;
            }
        }
        return true;
    }
}