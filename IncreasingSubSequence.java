public class Solution {
    Set<List<Integer>> answerSet = new HashSet<List<Integer>>();
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<2){
            return res;
        }
        //Arrays.sort(nums);
        List<Integer> cur = new LinkedList<>();
        dfs(nums,0,cur);
        return res;
    }
    
    private void dfs(int[]nums, int start, List<Integer> cur){
        if(cur.size()>=2){
            List<Integer> tmp = new LinkedList<>(cur);
            if(answerSet.contains(tmp)){
                return;
            }else{
                res.add(tmp);
                answerSet.add(tmp);
            }
        }
        for(int i = start;i<nums.length;i++){
            if(cur.size() == 0|| cur.get(cur.size()-1)<=nums[i]){
                cur.add(nums[i]);
                dfs(nums,i+1,cur);
                cur.remove(cur.size()-1);
            }

        }
    }
}