public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] length = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int sum = 0;
            int index =0;
            for(int j=i;j>=0;j--){
                if(sum>=s){
                    break;
                }else{
                    sum+=nums[j];
                    index++;
                }
            }
            length[i] = sum>=s?index:Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<length.length;i++){
            res = Math.min(length[i],res);
        }
        return res==Integer.MAX_VALUE? 0:res;
    }
}