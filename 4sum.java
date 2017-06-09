public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<4) return res;
        List<Integer> oneSolution = new LinkedList<>();
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        for(int i=0; i<=nums.length-4;i++){
            if(nums[i]+3*max<target){
                continue;
            }
            oneSolution.add(nums[i]);
            dfs(nums, target, res, oneSolution,nums[i],i,max);
            oneSolution.remove(0);
        }
        int resSize = res.size();
        if(resSize == 1){
            return res;
        }else{
            HashSet<List<Integer>> set = new HashSet<>();
            for(int i=0;i<resSize;i++){
                set.add(res.get(i));
            }
            res = new LinkedList<>(set);

        }
        return res;
    }
    
    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> oneSolution,int cur,int index,int max){
        if(cur==target && oneSolution.size() ==4){
            List<Integer> solution = new LinkedList<>(oneSolution);
            res.add(solution);
            return;
        }
        if(oneSolution.size()==4 && cur>target || index>=nums.length){
            return;
        }
        for(int i=index+1;i<nums.length;i++){
            int curSum = cur+nums[i];
            if(curSum+(4-oneSolution.size())*max<target){
                continue;
            }
            oneSolution.add(nums[i]);
            dfs(nums,target,res,oneSolution,cur+nums[i],i,max);
            oneSolution.remove(oneSolution.size()-1);
        }

    }
}  ///Time Limit Error