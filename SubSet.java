/*I am still need to become more familiary with backtracking and dfs*/





public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length==0){
            return res;
        }
        
        List<Integer> sub = new LinkedList<>();
        res.add(sub);
        int size = nums.length;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0;i<size;i++){
            index.put(nums[i],i);
        }
        for(int i=0;i<size;i++){
            int resSize = res.size();
            for(int j=0;j<resSize;j++){
                if(res.get(j).size()<i){
                    continue;
                }else{
                    List<Integer> cur = res.get(j);
                    int nextIndex=0;
                    if(cur.size()!=0){
                        nextIndex = index.get(cur.get(cur.size()-1))+1;
                    }
                    for(;nextIndex<size;nextIndex++){
                        List<Integer> newsub = new LinkedList<Integer>(cur);
                        newsub.add(nums[nextIndex]);
                        res.add(newsub);
                    }
                }
            }
        }
        return res;
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}