public class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean[] help = new boolean[length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1<length && nums[i]-1>=0){
                help[nums[i]-1]=true;
            }
        }
        int res=0;
        for(int i=0;i<length;i++){
            if(help[i]==false){
                res = i+1;
                return res;
            }
        }
        return length+1;
    }
}