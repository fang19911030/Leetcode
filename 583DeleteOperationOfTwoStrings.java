public class Solution {
    public int minDistance(String word1, String word2) {
        String shortstr = word1.length()<word2.length()? word1:word2;
        String longstr = word1.length()>=word2.length()? word1:word2;
        int[][] dp = new int[shortstr.length()][longstr.length()];
        int res = longestCommonSubstring(shortstr,longstr,0,0);
        return shortstr.length()+longstr.length()-2*res;
    }
    
    private int longestCommonSubstring(String s, String l, int startS, int startL){
        if(startS == s.length()|| startL == l.length()){
            return 0;
        }
        if(s.charAt(startS) == l.charAt(startL)){
            return 1+longestCommonSubstring(s,l,startS+1,startL+1);
        }else{
            return Math.max(longestCommonSubstring(s,l,startS+1,startL),longestCommonSubstring(s,l,startS,startL+1));
        }
    }
    public int minDistance2(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
                        : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int val =  dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }


    
    
}