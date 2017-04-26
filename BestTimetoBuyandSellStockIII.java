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
    public int maxProfit2(int[] prices) {
    // these four variables represent your profit after executing corresponding transaction
    // in the beginning, your profit is 0. 
    // when you buy a stock ,the profit will be deducted of the price of stock.
    int firstBuy = Integer.MIN_VALUE, firstSell = 0;
    int secondBuy = Integer.MIN_VALUE, secondSell = 0;

    for (int curPrice : prices) {
        if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
        if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
        if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
        if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
    }
    
    return secondSell; // secondSell will be the max profit after passing the prices
    }

    public int maxProfit3(int[] prices){
        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];

        forward[0] = 0;
        int min_buy = prices[0];
        for(int i=1;i<prices.length;i++){
            forward[i] = Math.max(forward[i-1],prices[i]-min_buy);
            min_buy = Math.min(prices[i],min_buy);
        }
        int length = prices.length;
        backward[length-1] =0;
        max_sell = prices[length-1];
        for(int i=length-2;i>=0;i--){
            backward[i] = Math.max(backward[i+1],max_sell-prices[i]);
            max_sell = Math.max(prices[i],max_sell);
        }

        int res = 0;
        for(int i=0;i<length;i++){
            res = Math.max(res,backward[i]+forward[i]);
        }
        return res;
    }
} 