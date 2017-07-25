public class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            res++;
        }

        for(int l=2;l<=s.length();l++){
            for(int i=0; i+l-1<s.length();i++){
                int j = i+l-1;
                if(j-i==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        res++;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;

    }
}