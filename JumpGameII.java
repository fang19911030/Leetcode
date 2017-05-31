public class Solution {
    public int jump(int[] nums) {
        return help(nums,0,nums.length-1,0);
    }
    
    private int help(int[]nums, int start, int end, int steps){
        if(start>=end){
            return steps;
        }
        if(nums[start]==0){
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=nums[start];i++){
            res = Math.min(res,help(nums,start+i,end,steps+1));
        }
        return res;
    }

    public int jump2(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;

                if (curEnd >= A.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}                 //TLE