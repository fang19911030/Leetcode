public class TrappingWater{
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
    private void getLeft(int[]height, int[] left){
        left[0] = -1;
        for(int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i-1]);
        }
    }
    
    private void getRight(int[] height, int[] right){
        right[height.length-1] = -1;
        for(int i=height.length-2;i>=0;i--){
            right[i] = Math.max(height[i+1],right[i+1]);
        }
    }
    public int trap2(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        int res = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        getLeft(height,left);
        getRight(height,right);
        for(int i=0;i<height.length;i++){
            int lb = left[i];
            int rb = right[i];
            if(lb == -1 || rb == -1){
                continue;
            }
            
            if(height[i]<lb && height[i] <rb){
                res+= lb>=rb? rb-height[i]:lb-height[i];
            }

        }
        return res;
    }
}