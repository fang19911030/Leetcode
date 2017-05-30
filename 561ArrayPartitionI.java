public class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length;i=i+2){
            res+=nums[i];
        }
        return res;
    }
}