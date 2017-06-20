public class Solution {
    private List<List<Integer>> res;
    private Set<List<Integer>> resSet;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        res = new LinkedList<List<Integer>>();
        if(target<candidates[0]){
            return res;
        }
        List<Integer> cur = new LinkedList<>();
        resSet = new HashSet<List<Integer>>();
        dfs(candidates,target,0,0,cur);
        return res;
    }
    
    private void dfs(int[]arr, int target,int curSum, int left,List<Integer> cur){
        if(curSum==target){
            List<Integer> tmp = new LinkedList<>(cur);
            if(!resSet.contains(tmp)){
                res.add(tmp);
                resSet.add(tmp);
            }
            return;
        }
        // if(curSum>target){
        //     return;
        // }
        for(int i=left;i<arr.length && arr[i]<=target-curSum;i++){
            cur.add(arr[i]);
            dfs(arr,target,curSum+arr[i],i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}