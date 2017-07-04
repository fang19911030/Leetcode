public class ExpressionAddOperators{
    public List<String> addOperators(String num, int target) {
        List<String>solutions = new LinkedList<>();
        if(num==null || num.length()==0){
            return solutions;
        }
        dfs(solutions,"",num,target,0,0,0);
        return solutions;
    }
    
    private void dfs(List<String>solutions,String path,String num, int target,int pos,long eval,long multed){
        if(pos==num.length() && eval == target){
            solutions.add(path);
            return;
        }
        if(pos == num.length()){
            return;
        }
        for(int i=pos;i<num.length();i++){
            if(i != pos && num.charAt(pos)=='0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos == 0){
                dfs(solutions,path+cur,num,target,i+1,cur,cur);
            }else{
                dfs(solutions,path+"+"+cur,num,target,i+1,eval+cur,cur);
                dfs(solutions,path+"-"+cur,num,target,i+1,eval-cur,-cur);
                dfs(solutions,path+"*"+cur,num,target,i+1,eval-multed+multed*cur,multed*cur);
            }
        }
    }
}