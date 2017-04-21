public class Solution {
    public int numDistinct(String s, String t) {
        if(s==null || t == null || t.length()>s.length()){
            return 0;
        }
        int[][] matrix = new int[t.length()+1][s.length()+1];
        int row = t.length()+1;
        int col = s.length()+1;
        
        for(int i=0;i<col;i++){
            matrix[0][i]=1;
        }
        
        
        for(int i =0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == t.charAt(i)){
                    matrix[i+1][j+1] = matrix[i][j]+matrix[i+1][j]; 
                }else{
                    matrix[i+1][j+1] = matrix[i+1][j];
                }
            }
        }
        return matrix[row-1][col-1];
        

    }

}