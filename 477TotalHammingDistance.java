public class Solution {    //TLE
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                res += getDiff(nums[i],nums[j]);
            }
        }
        return res;
    }
    
    public int getDiff(int i, int j){
        int big = i>=j? i:j;
        int small= i<j? i:j;
        String bignum = Integer.toBinaryString(big);
        String smallnum = Integer.toBinaryString(small);
        int diff = bignum.length()-smallnum.length();
        int index = 0;
        int res = 0;
        for(int v=0;v<bignum.length();v++){
            if(v<diff){
                res = bignum.charAt(v)=='1'? res+1:res;
            }else{
                if(bignum.charAt(v)!=smallnum.charAt(index++)){
                    res++;
                }
            }
        }
        return res;
    }
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++) 
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}