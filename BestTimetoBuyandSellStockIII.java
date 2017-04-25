public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int[] diff1 = new int[prices.length];
        diff1[0] = 0;
        for(int i=1;i<prices.length;i++){
            diff1[i] = prices[i]-prices[0];
        }
        // for(int i=0;i<diff1.length;i++){
        //     System.out.println(diff1[i]);
        // }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<diff1.length;i++){
            int max1=0;
            int max2 =0;

            int res = findMax(diff1,i+1,diff1.length-1);
            max1 = res>0? res:max1;
            res = findMax(diff1,0,i);
            max2 = res>0? res:max2;
            max = Math.max(max,max1+max2);

        }
        return max>0? max:0;
    }
    public int findMax(int[] diff1, int left, int right){
        if(left>=right){
            return 0;
        }
        int max = 0;
        for(int i=left;i<right;i++){
            for(int j=i+1;j<=right;j++){
                max = Math.max(max,diff1[j]-diff1[i]);
            }
        }
        return max;
    }
}