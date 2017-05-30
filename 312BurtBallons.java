public class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length+2];
        num[0]=1;
        num[num.length-1] = 1;
        int index = 1;
        for(int i=0;i<nums.length;i++){
            num[index++] = nums[i];
        }
        int[][] memory = new int[num.length][num.length];
        return help(memory,num,0,num.length-1);
    }
    
    private int help(int[][] memory, int[]nums, int left, int right){
        if(left+1 == right) return 0;
        if(memory[left][right]>0) return memory[left][right];
        int ans = 0;
        for(int i=left+1;i<right;i++){
            ans = Math.max(ans,nums[left]*nums[i]*nums[right]
            +help(memory,nums,left,i)+help(memory,nums,i,right));
        }
        memory[left][right] = ans;
        return ans;
    }
}