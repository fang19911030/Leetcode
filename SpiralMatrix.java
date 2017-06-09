public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] ul = {0,0};
        int[] ur = {0,matrix[0].length-1};
        int[] bl = {matrix.length-1,0};
        int[] br = {matrix.length-1,matrix[0].length-1};
        List<Integer> res = new LinkedList<Integer>();
        int size = matrix.length*matrix[0].length;
        while(res.size<=size){
        	addNumber(ul,ur,bl,br,clockwise,res,matrix);
        	ul[0]++;
        	ul[1]++;
        	ur[0]++;
        	ur[1]--;
        	bl[0]--;
        	bl[1]++;
        	br[0]--;
        	br[1]--;
        }
        return res;

    }

    private void addNumber(int[] ul,int[] ur,int[] bl,int[] br, 
    	LinkedList<Integer>res,int[][] matrix){
		for(int i=ul[1];i<ur[1];i++){
			res.add(matrix[ul[0]][i]);
		}
		for(int i=ur[0];i<br[0];i++){
			res.add(matrix[i][br[1]]);
		}
		for(int i=br[1];i>bl[1];i--){
			res.add(matrix[ur[0]][i]);
		}
		for(int i=bl[0];i>ul[0];i--){
			res.add(matrix[i][bl[1]]);
		}

    }
}


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
}