public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            
            int left = findLeft(height,i);
            int right = findRight(height,i);
            
            if( left == -1 || right == -1){
                continue;
            }
            int boundary = Math.min(left,right);
            res +=boundary-height[i];
        }
        return res;
    }
    
    private int findLeft(int[] height, int index){
        if(index == 0){
            return -1;
        }
        int res = -1;
        for(int i=index-1;i>=0;i--){
            if(height[i]>height[index]){
                res = Math.max(res,height[i]);
            }
        }
        return res;
    }
    
    private int findRight(int[] height, int index){
        if(index == height.length-1){
            return -1;
        }
        int res = -1;
        for(int i = index+1;i<height.length;i++){
            if(height[i]>height[index]){
                res = Math.max(height[i],res);
            }
        }
        return res;
        
    }
}