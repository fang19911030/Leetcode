public class Solution {
    public int findLongestChain(int[][] pairs) {
        List<Integer[]> list = new LinkedList<>();
        for(int i=0;i<pairs.length;i++){
            Integer[] cur = new Integer[2];
            cur[0] = pairs[i][0];
            cur[1] = pairs[i][1];
            list.add(cur);
        }
        Collections.sort(list,(a,b)->a[1]-b[1]);
        int res = 1;
        Integer[] pre = list.get(0);
        for(int i=1;i<list.size();i++){
            Integer[] cur = list.get(i);
            if(cur[0]>pre[1]){
                res++;
                pre = cur;
            }
        }
        return res;
    }
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        
        int i, j, max = 0, n = pairs.length;
        int dp[] = new int[n];
      
        for (i = 0; i < n; i++) dp[i] = 1;
        
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        for (i = 0; i < n; i++) if (max < dp[i]) max = dp[i];
        
        return max;
    }
}