//for ssh test3

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        for(int i=0;i<nums.length-2 && nums[i]<=0;i++){
            if(nums[i]+2*max<0){
                continue;
            }
            for(int j=i+1;j<nums.length-1;j++){
                int cur = nums[i]+nums[j];
                int target = -cur;
                if(target>max) continue;
                int[] bisearch = search(nums, j+1, nums.length-1,target);
                if(bisearch[0]==1){
                    List<Integer> oneSolution = new LinkedList<>();
                    oneSolution.add(nums[i]);
                    oneSolution.add(nums[j]);
                    oneSolution.add(nums[bisearch[1]]);
                    res.add(oneSolution);
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<res.size();i++){
            set.add(res.get(i));
        }
        res = new LinkedList<>(set);
        
        return res;
    }
    
    private int[] search(int[] nums, int left, int right, int target){
        int[] res = new int[2];
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right =mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                res[0] =1 ;
                res[1] = mid;
                break;
            }
        }
        return res;
    }
}

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
