public class solution{
	public boolean is_Interleave(String s1, int i, String s2, int j,String res, String s3){
		if(res.equals(s3) && i==s1.length() && j == s2.length()){
			return true;
		}
		boolean res = false;
		if(i<s1.length()){
			res |=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
		}
		if(j<s2.length()){
			res |=is_Interleave(s1,i,s2,j+1,res+s2.charAt(i),s3);
		}
		return res;
	}

	public boolean isInterleave(String s1,String s2, String s3){
		return is_Interleave(s1,0,s2,0,"",s3);
	}

	public boolean is_Interleave(String s1,int i,String s2, int j,String s3,int k,int[][]memo){
		if(i==s1.length()){
			return s2.substring(j).equals(s3.substring(k));
		}
		if(j==s2.length()){
			return s1.substring(j).equals(s3.substring(k));
		}
		if(memo[i][j]>=0){
			return memo[i][j]==1? true:false;
		}
		boolean ans = false;
		if(s3.charAt(k) == s1.charAt(i) && is_Interleave(s1,i+1,s2,j,s3,k+1,memo) ||
			s3.charAt(k) ==s2.charAt(j) && is_Interleave(s1,i,s2,j+1,s3,k+1,memo)){
			ans = true;
		}
		memo[i][j]=ans? 1:0;
		return ans;
	}

	public isInterleave2(String s1, String s2, String s3){
		int[][] memo = new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				memo[i][j] = -1;
			}
		}
		return is_Interleave(s1,0,s2,0,s3,0,memo);
	}
	public boolean isInterleave3(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}