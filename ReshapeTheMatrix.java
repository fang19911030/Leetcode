public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int originalSize = nums.length * nums[0].length;
        int size = r*c;
        if(size != originalSize){
            return nums;
        }
        int[][] res = new int[r][c];
        int row = 0;
        int col = 0;
        for(int i=0;i<nums.length;i++){
            for(int j = 0 ; j < nums[0].length ; j++){
                if(col == c ){
                    col = 0;
                    res[++row][col++] = nums[i][j];
                }else{
                    res[row][col++] = nums[i][j];
                }
            }
        }
        return res;
    }
}