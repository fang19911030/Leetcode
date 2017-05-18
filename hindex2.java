public class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length -1 ;
        int len = citations.length;
        while(left<=right){
            int mid =(left+right)/2;
            int h = citations[mid];
            if(h == len-mid) return h;
            else if(h>len-mid) right = mid-1;
            else left = mid+1;
        }
        return citations.length-right -1;
        
    }
}