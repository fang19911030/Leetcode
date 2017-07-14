public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> candidates = getAll(n);
        List<String> solution = new ArrayList<String>();
        for(String cur:candidates){
            if(valid(cur)){
                solution.add(cur);
            }
        }
        return solution;
    }
    
    private Set<String> getAll(int n){
        String left="";
        String right = "";
        for(int i=0;i<n;i++){
            left =left+"(";
            right=right+")";
        }
        String tmp="";
        Set<String> res = new HashSet<String>();
        help(left,0,right,0,res,tmp);
        return res;
    }
    
    private void help(String left, int curl, String right,int curR, Set<String> res,String tmp){
        if(curl==left.length() && curR == right.length()){
            res.add(tmp);
            return;
        }
        if(curl==left.length()){
            help(left,curl,right,curR+1,res,tmp+right.charAt(curR));
        }
        if(curR == right.length()){
            help(left,curl+1,right,curR,res,tmp+left.charAt(curl));
        }
        if(curl<left.length() && curR<right.length()){
            help(left,curl+1,right,curR,res,tmp+left.charAt(curl));
            help(left,curl,right,curR+1,res,tmp+right.charAt(curR));
        }
    }
    
    private boolean valid(String str){
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }

}