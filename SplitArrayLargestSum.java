public class Solution{
	Map<String, Integer> map;
	int[][] sumMap;
	public int splitArray(int[]nums, int m){
		map = new HashMap<>();
		sumMap = new int[nums.length][nums.length];
		for(int i=0;i<nums.length;i++){
			int sum = 0;
			for(int j=i;j<nums.length;j++){
				sum+=nums[j];
				dp[i][j] = sum;
			}
		}
		return helper(nums,m,0,nums.length-1);
	}

	private int helper(int[] nums,int m, int low, int high){
		String key = String.format("%d#%d#%d",low, high,m);
		if(m == 1){
			int sum = sumMap[low][high];
			map.put(key,sum);
			return sum;
		}

		if(map.containsKey(key)){
			return map.get(key);
		}
		int max = Integer.MAX_VALUE;

		for(int i=low;i<=hight-m+1;i++){
			int tmp = Math.max(sumMap[low][i],helper(nums,m-1,i+1,high));
			max = Math.min(tmp, max);
		}
		map.put(key, max);
		return max;
	}

	public int splitArray2(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for(int num:nums){
            sum+=num;
            max = Math.max(num,max);
        }
        if(m == 1) return (int)sum;
        
        long l = max;
        long r = sum;
        while(l<=r){
            long mid = (l+r)/2;
            if(valid(mid,nums,m)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)l;
    }
    
    private boolean valid(long mid, int[] nums, int m){
        int count=1;
        long total=0;
        for(int num:nums){
            total+= num;
            if(total >mid){
                total = num;
                count++;
                if(count>m){
                    return false;
                }
            }
        }
        return true;
    }


}