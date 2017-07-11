public class Solution {
    String[] symbols = {"+","-"};

        
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length==0){
            return 0;
        }
        return help(nums,0,0, S);
    }
    
    
    private int help(int[] nums, int start, int cur, int S){
        if( start== nums.length){
            if(cur == S){
                return 1;
            }else{
                return 0;
            }
        }
        int res = 0;
        for(String op:symbols){
            if(op.equals("+")){
                res += help(nums,start+1,cur+nums[start],S);
            }else{
                res += help(nums,start+1,cur-nums[start],S);
            }
        }
        return res;
    }
    public int findTargetSumWays2(int[] nums, int S) {
        if(nums == null || nums.length==0){
            return 0;
        }
        HashMap[] maps = new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            maps[i] = new HashMap<Integer, Integer>();
        }
        return help(nums,0,0, S,maps);
    }

    private int help(int[] nums, int cur, int start, int S,HashMap[]maps){
        if(start == nums.length){
            if(cur == S){
                return 1;
            }else{
                return 0;
            }
        }
        if(maps[start].containsKey(cur)){
            return (Integer)maps[start].get(cur);
        }
        int res = 0;
        for(String op: symbols){
            if(op.equals("+")){
                res += help(nums,cur+nums[start],start+1,S,maps);
            }else{
                res += help(nums,cur-nums[start],start+1,S,maps);
            }
        }
        maps[start].put(cur,res);
        return res;
    }
}