public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Map<Integer,Integer> sums = new HashMap<Integer,Integer>();
        getSum(root,sums);
        //System.out.print(sums.keySet().size());
        int max = 0;
        List<Integer> res= new ArrayList<Integer>();
        for(Integer key: sums.keySet()){
            if(sums.get(key) >max){
                res = new ArrayList<Integer>();
                res.add(key);
                max = sums.get(key);
            }else if(sums.get(key)==max){
                res.add(key);
            } 
        }
        int[] solution = new int[res.size()];
        for(int i=0;i<solution.length;i++){
            solution[i] = res.get(i);
        }
        return solution;
    }
    
    private int getSum(TreeNode x, Map<Integer,Integer> sums){
        if(x == null){
            return 0;
        }
        int left = getSum(x.left,sums);
        int right = getSum(x.right,sums);
        int sum = left+right+x.val;
        sums.put(sum,sums.getOrDefault(sum,0)+1);
        return sum;
    }
}