public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if(numRows == 0){
            return res;
        }
        List<Integer> first = new LinkedList<>();
        first.add(1);
        res.add(first);
        for(int i=1;i<numRows;i++){
            List<Integer> cur = new LinkedList<>();
            List<Integer> pre = res.get(res.size()-1);
            for(int j=0;j<i+1;j++){
                if(j == 0){
                    cur.add(1);
                }else if( j == i){
                    cur.add(1);
                }else{
                    int curVal = pre.get(j-1)+pre.get(j);
                    cur.add(curVal);
                }
            }
            res.add(cur);
        }
        return res;
    }
}