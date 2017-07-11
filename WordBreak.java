//Top down method is hard

import java.util.*;
public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {     //TLE DFS
        List<String> res = new ArrayList<>();
        if(s == null || wordDict== null || wordDict.size() == 0){
            return res;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        help(s,dict,"",0,res,dp);
        return res;

    }

    private void help(String s, Set<String>dict,String tmp, int index,List<String> res,boolean[] dp){
        if(index == s.length()){
            if(dp[index]==true){
                res.add(tmp);
                return;
            }else{
                return;
            }
        }
        for(int j=index;j<=s.length();j++){
            String sub = s.substring(index, j);
            if(dict.contains(sub)&& dp[index]==true){
                dp[j] = true;
                String newtmp = null;
                if(tmp.length() == 0){
                    newtmp = tmp+sub;
                }else{
                    newtmp = tmp+" "+sub;
                }
                help(s,dict,newtmp,j,res,dp);
                dp[j] = false;
            }
        }

    }

    public static void main(String[] args){
        String s = "catsanddog";

        String[] strs = {"cat", "cats", "and", "sand", "dog"};
        List<String> dict = new ArrayList<>();
        for(String str:strs){
            dict.add(str);
        }
        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak(s,dict));
    }
}