public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int minimum =Integer.MAX_VALUE;
        int secondminimum = Integer.MAX_VALUE;
        if(nums.length<3){
            return false;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>minimum && nums[i]>secondminimum){
                return true;
            }else if(nums[i]<minimum){
                minimum = nums[i];
            }else if(nums[i]>minimum && nums[i]<secondminimum){
                secondminimum = nums[i];
            }
        }
        return false;
    }
}// I think this is my first best solution.