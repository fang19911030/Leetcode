public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null ){
            return false;
        }
        boolean rotated  = isRotated(nums);
        if(rotated){
            return binarySearchInRotated(nums, target);
        }else{
            return binarySearch(nums, target,0,nums.length-1);
        }
    }
    
    private boolean isRotated(int[]nums){
        if(nums.length>1){
            return nums[0]>=nums[nums.length-1];
        }else{
            return false;
        }
    }
    
    private boolean binarySearch(int[] nums, int target,int i, int j){
        int left = i;
        int right = j;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target>nums[mid]){
                while(mid<right && nums[mid]==nums[mid+1]){
                    mid++;
                }
                left = mid+1;
            }else if(target<nums[mid]){
                while(mid>left && nums[mid] == nums[mid-1]){
                    mid--;
                }
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
    
    private boolean binarySearchInRotated(int[]nums,int target){
        int left1 = 0;
        int right2 = nums.length-1;
        int right1 =0;
        int left2 = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                right1 = i;
                left2 = i+1;
                break;
            }
        }
        if(target>nums[right2]){
            return binarySearch(nums,target,left1,right1);
        }else{
            return binarySearch(nums,target,left2,right2);
        }
    }
}