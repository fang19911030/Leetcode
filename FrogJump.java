public class Solution {
    public boolean canCross(int[] stones) {
        int[] steps = new int[stones.length];
        steps[0] = 0;
        HashMap<String,Boolean> memo = new HashMap<>();
        return help(stones,steps,0, memo);
    }
    
    private boolean help(int[]stones, int[] steps,int cur,HashMap<String, Boolean>memo){
        if(cur == stones.length-1){
            return true;
        }
        String key = String.valueOf(cur)+ String.valueOf(steps[cur]);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        boolean res = false;
        for(int i=steps[cur]+1;i>=0 && i>=steps[cur]-1;i--){
            for(int j = cur+1;j<stones.length;j++)
                if(stones[cur]+ i ==stones[j]){
                    steps[j] = i;
                    res |= help(stones,steps,j, memo);
                    memo.put(String.valueOf(j)+String.valueOf(i),res);
                }
        }
        return res;
    }
}