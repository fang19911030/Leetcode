/*How to get the mid is the key point here. If we use mid = (left+right)/2, it may overflow if left
and right are big numbers.*/


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while(left<=right){
            int mid =left +(right-left)/2;               
            if(isBadVersion(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
            
        }
        return left;
    }
}