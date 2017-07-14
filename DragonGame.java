public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] d = dungeon;
        int r= d.length;
        int c = d[0].length;
        int[][] blood = new int[d.length][d[0].length];
        blood[r-1][c-1] = d[r-1][c-1]>=0? 1:1-d[r-1][c-1];
        for(int i=r-2;i>=0;i--){
            blood[i][c-1] = blood[i+1][c-1]-d[i][c-1]>0? blood[i+1][c-1]-d[i][c-1]:1;
        }
        for(int j=c-2;j>=0;j--){
            blood[r-1][j] = blood[r-1][j+1]-d[r-1][j]>0? blood[r-1][j+1]-d[r-1][j]:1;
        }
        for(int i=r-2;i>=0;i--){
            for(int j=c-2;j>=0;j--){
                int right = blood[i][j+1]-d[i][j]>0? blood[i][j+1]-d[i][j]:1;
                int down = blood[i+1][j]-d[i][j]>0? blood[i+1][j]-d[i][j]:1;
                blood[i][j] = Math.min(right,down);
            }
        }
        return blood[0][0];
        
    }
}