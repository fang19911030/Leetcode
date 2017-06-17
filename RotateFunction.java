public class Solution {
    public int maxRotateFunction(int[] A) {
        
        if(A==null||A.length==0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int length = A.length;
        for(int i=0;i<length;i++){
            int sum = 0;
            for(int j=0;j<length;j++){
                int c = (i+j)%length;
                sum+=c*A[j];
            }
            res = Math.max(res,sum);
        }
        return res;

    }

    public int maxRotateFunction2(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;   
    }
}