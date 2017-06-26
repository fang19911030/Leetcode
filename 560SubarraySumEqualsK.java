public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>[] sums = new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            sums[i] = new HashMap<Integer,Integer>();
            sums[i].put(nums[i],1);
        }
        for(int i=1;i<nums.length;i++){
            int sum = nums[i];
            for(int j=i-1;j>=0;j--){
                sum +=nums[j];
                sums[i].put(sum,sums[i].getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for(int i=0;i<sums.length;i++){
            res+=sums[i].getOrDefault(k,0);
        }
        return res;

    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}