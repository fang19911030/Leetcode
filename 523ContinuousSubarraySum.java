public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }

        for(int i=0; i<nums.length ; i++){
            int sum = nums[i];
            for(int j= i+1 ; j<nums.length;j++){
                sum = sum+ nums[j];
                if(k!= 0 && isMultiple(sum,k)){
                    return true;
                }else{
                    if(k == 0){
                        if(sum == 0){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isMultiple(int sum, int k){
        return sum%k==0;
    }
}