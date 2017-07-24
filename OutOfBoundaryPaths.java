public class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        long
        return (int)help(m,n,N,i,j)%1000000007;
    }
    
    private long help(int m, int n, int N, int i, int j){
        if(N>0 && i<0 || i>=m || j<0 || j>=n){
            return 1;
        }
        if(N==0){
            if(i<0 || i>=m || j<0 || j>=n){
                return 1;
            }
            return 0;
        }
        long res = 0;
        for(int[] next:directions){
            int nextI = i+next[0];
            int nextJ = j+next[1];
            res += help(m,n,N-1,nextI,nextJ);
        }
        return res;           //TLE;
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }
        
        return result;
    }

    public int findPaths3(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[N][m][n];
        for(int step=0;step<N;step++){
            for(int r=0;r<m;r++){
                for(int c=0;c<n;c++){
                    dp[step][r][c] = -1;
                }
            }
        }
        return (int)help(m,n,N,i,j,dp)%1000000007;     //have wrong answer
    }
    
    private long help(int m, int n, int N, int i, int j,long[][][]dp){
        if(N>0 && i<0 || i>=m || j<0 || j>=n){
            return 1;
        }
        if(N==0){
            if(i<0 || i>=m || j<0 || j>=n){
                return 1;
            }
            return 0;
        }
        if(dp[N-1][i][j]!= -1) return dp[N-1][i][j];
        long res = 0;
        for(int[] next:directions){
            int nextI = i+next[0];
            int nextJ = j+next[1];
            res += help(m,n,N-1,nextI,nextJ,dp);
        }
        dp[N-1][i][j] = res;
        return res;
    }


}