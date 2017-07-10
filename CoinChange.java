public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount == 0) return 0;
        if(amount<coins[0]) return -1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amount];
        }
    }
}