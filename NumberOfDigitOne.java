public class Solution {
    public int countDigitOne(int n) {
        if(n<0){
            return 0;
        }
        int res =0;
        for(int i=1;i<=n;i++){
            int[] nums=numToArray(i);
            res +=countOne(nums);
        }
        return res;
    }
    
    private int[] numToArray(int n){
        int i=0;
        int tmp = n;
        while(n>0){
            i++;
            n = n/10;
        }
        int[] res= new int[i];
        int index = i-1;
        while(tmp>0){
            res[index--] = tmp%10;
            tmp = tmp/10;
        }
        return res;
    }
    private int countOne(int[] n){
        int res = 0;
        for(int i=0;i<n.length;i++){
            if(n[i] == 1){
                res+=1;
            }
        }
        return res;
    }
}