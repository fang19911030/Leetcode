public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right ){
            int mid = left +(right-left)/2;
            if(nums[mid]!= nums[mid-1] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }else if(nums[mid] == nums[mid-1]){
                if((mid-left+1)%2 == 0){
                    left = mid+1;
                }else{
                    right = mid-2;
                }
            }else if(nums[mid] == nums[mid+1]){
                if((right-mid+1)%2 == 0){
                    right = mid - 1;
                }else{
                    left = mid+2;
                }
            }
        }
        return nums[left];
    }
}