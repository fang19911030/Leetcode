public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null){
            return false;
        }
        
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for(int pos = 0; pos<strs.length;pos++){
            String curr = strs[pos];
            while(curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)){
                st.pop();
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int degree = -1;         // root has no indegree, for compensate init with -1
        for (String str: strs) {
            degree++;             // all nodes have 1 indegree (root compensated)
            if (degree > 0) {     // total degree should never exceeds 0
                return false;
            }      
            if (!str.equals("#")) {// only non-leaf node has 2 outdegree
                degree -= 2;
            }  
        }
        return degree == 0;
    }
}