public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length<2){
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] bucketMIN = new int[nums.length-1];
        int[] bucketMAX = new int[nums.length-1];
        Arrays.fill(bucketMIN,Integer.MAX_VALUE);
        Arrays.fill(bucketMAX,Integer.MIN_VALUE);
        for(int i:nums){
            if(i == min || i == max){
                continue;
            }
            int idx = (i-min)/gap;
            bucketMIN[idx] = Math.min(i,bucketMIN[idx]);
            bucketMAX[idx] = Math.max(i, bucketMAX[idx]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i =0 ; i<nums.length -1;i++){
            if(bucketMIN[i] == Integer.MAX_VALUE && bucketMAX[i] == Integer.MIN_VALUE)
                continue;
                
            maxGap = Math.max(maxGap,bucketMIN[i]-previous);       //先更新
            previous = bucketMAX[i];
        }
        
        maxGap = Math.max(maxGap, max-previous);
        return maxGap;
        
    
    }
}
