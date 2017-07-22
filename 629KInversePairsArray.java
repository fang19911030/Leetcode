public class Solution {
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n][k+1];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                if(j>0){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                    dp[i][j]=j-i>0?(dp[i][j]-dp[i-1][j-i-1]):dp[i][j];
                }
                else{
                    for(int m=j;m>=0&&m>=(j-i);m--){
                        dp[i][j]+=dp[i-1][m];
                    }
                }
                dp[i][j]=dp[i][j]>0?dp[i][j]%1000000007:(dp[i][j]+1000000007)%1000000007;
            }
        }
        return (int)dp[n-1][k];
    }

    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n][k+1];
        dp[0][0]=1;//mean sum of arrays that consist of 1 with 0 inverse pairs
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int m=j;m>=0&&m>=(j-i);m--){
                    dp[i][j]+=dp[i-1][m];
                }
                dp[i][j]=dp[i][j]%1000000007;
            }
        }
        return (int)dp[n-1][k];
    }
}