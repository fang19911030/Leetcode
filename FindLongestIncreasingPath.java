/**
 * Created by fang on 4/27/17.
 */
public class FindLongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix == null || matrix.length == 0){
            return max;
        }
        //boolean[][] path= new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                boolean[][] path= new boolean[matrix.length][matrix[0].length];
                int cur = findLongest(matrix, i, j,1,path);
                max = Math.max(max,cur);
            }
        }
        return max;
    }

    public int findLongest(int[][] matrix, int curRow, int curCol,int length,boolean[][]path){
        path[curRow][curCol] = true;
        int max = length;
        int cur = matrix[curRow][curCol];
        if(curCol+1<matrix[0].length && cur>matrix[curRow][curCol+1] && path[curRow][curCol+1] == false){
            length+=1;
            int res = findLongest(matrix,curRow,curCol+1,length,path);
            length--;
            max = Math.max(max,res);
        }
        if(curCol-1>=0 && cur>matrix[curRow][curCol-1] && path[curRow][curCol-1] == false){
            int res = findLongest(matrix,curRow,curCol-1,++length,path);
            length--;
            max = Math.max(res,max);
        }
        if(curRow+1<matrix.length && cur>matrix[curRow+1][curCol] && path[curRow+1][curCol] == false){
            int res = findLongest(matrix,curRow+1,curCol,++length,path);
            length--;
            max = Math.max(res, max);
        }
        if(curRow-1>=0 && cur>matrix[curRow-1][curCol] && path[curRow-1][curCol] == false){
            int res = findLongest(matrix,curRow-1,curCol,++length,path);
            max = Math.max(res,max);
        }
        path[curRow][curCol] = false;
        return max;


    }

    public static void main(String[] args){
        int[][] nums = {{6,8},{7,2}};
        int[][] nums2 ={{7,8,9},{9,7,6},{7,2,3}};
        int[][] nums3={{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        FindLongestIncreasingPath solution = new FindLongestIncreasingPath();
        int res = solution.longestIncreasingPath(nums3);
        System.out.println(res);
    }
}