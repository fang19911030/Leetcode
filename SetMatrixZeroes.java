public class Solution {
    public void setZeroes(int[][] matrix) {
        int r= matrix.length;
        int c = matrix[0].length;
        boolean[][] zeros = new boolean[r][c];
        setZeros(matrix,zeros);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(zeros[i][j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
    
    private void setZeros(int[][]matrix, boolean[][]zeros){
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(row[i] || col[j]){
                    zeros[i][j] = true;
                }else{
                    zeros[i][j] = false;
                }
            }
        }
    }
} // it can very easy to modify this solution to O(m+n) space