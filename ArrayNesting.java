public class Solution {     //stack Overflow
    public int arrayNesting(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(i, nums[i]);
        }
        boolean[] visited = new boolean[nums.length];
        int res = 1;
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                res = Math.max(res, dfs(map,visited,i,0));
            }
        }
        return res;
    }
    
    private int dfs(HashMap<Integer,Integer> map, boolean[]visited,int index, int cur){
        visited[index] = true;
        if(visited[map.get(index)]){
            return cur+1;
        }
        int res = 1;
        res = dfs(map,visited,map.get(index),cur+1);
        return res;
    }

    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}