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


    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
} // it can very easy to modify this solution to O(m+n) space