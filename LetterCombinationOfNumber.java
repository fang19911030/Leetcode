public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length()==0){
            return res;
        }
        String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        dfs(keyboard,digits,0,res,sb,0);
        return res;
    }
    
    private void dfs(String[] keyboard,String digits,int index, List<String> res, StringBuilder sb,int nums){
        if(nums==digits.length()){
            String str = sb.toString();
            res.add(str);
        }
        if(index>=digits.length()){
            return;
        }
        if(digits.charAt(index)=='1' || digits.charAt(index)=='0'){
            dfs(keyboard,digits,index+1,res,sb,nums+1);
        }else{
            int num = digits.charAt(index)-'0';
            for(int i=0;i<keyboard[num].length();i++){
                sb.append(keyboard[num].charAt(i));
                dfs(keyboard,digits,index+1,res,sb,nums+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}