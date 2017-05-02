public class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length<4){
            return false;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        if(sum %4 !=0){
            return false;
        }
        
        Arrays.sort(nums);
        reverse(nums);
        
        return dfs(nums,new int[4], 0, sum/4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target){
        if(index == nums.length){
            if(sums[0] == target && sums[1] == target && sums[2] == target){
                return true;
            }
            return false;
        }
        
        for(int i=0;i<4;i++){
            if(sums[i]+nums[index]>target){
                continue;
            }
            sums[i]+= nums[index];
            if(dfs(nums,sums,index+1,target)){
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }
    
    private void reverse(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}