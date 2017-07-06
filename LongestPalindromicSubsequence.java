public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) { //TLE  m*pow(2,m) awuful
        Set<String> subSequences = new HashSet<String>();
        char[] str = s.toCharArray();
        getSubSequences(str,0,subSequences,"");
        subSequences.remove("");
        int res = 0;
        for(String tmp:subSequences){
            if(isValid(tmp)){
                res = Math.max(res,tmp.length());
            }
        }
        return res;
    }

    private void getSubSequences(char[] str, int cur,Set<String> set, String res){
        if(cur == str.length){
            set.add(res);
            return;
        }
        getSubSequences(str,cur+1,set,res+str[cur]);
        getSubSequences(str,cur+1,set, res);
    }

    private boolean isValid(String str){
        int left = 0;
        int right =str.length()-1;
        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    // public static void main(String[] args){
    //     String a = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
    //     LongestPalindromicSubsequence test = new LongestPalindromicSubsequence();
    //     System.out.println(test.longestPalindromeSubseq(a));
    // }

    public int longestPalindromeSubseq2(String s){
        int[][] dp = new int[s.length()][s.length()];

        for(int i=s.length()-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j = i+1;j<s.length();j++){
                if(s.charAt(j) == s.charAt(i)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public int longestPalindromeSubseq3(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }






}   