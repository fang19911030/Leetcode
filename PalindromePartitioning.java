public class Solution {
    List<List<String>> res;
    List<String> cur;
    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        cur = new LinkedList<>();
        if(s == null){
            return res;
        }
        backTrack(s, 0);
        return res;
        
    }
    
    public void backTrack(String s, int l){
        if(cur.size()> 0 && l >= s.length()){
            List<String> r = new LinkedList<>(cur);
            res.add(r);
        }
        
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i){
                    cur.add(Character.toString(s.charAt(i)));
                }else{
                    cur.add(s.substring(l,i+1));
                }
                backTrack(s,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s,int l, int r){
        int left = l;
        int right = r;
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}