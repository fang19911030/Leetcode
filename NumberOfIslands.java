public class Solution {
    int[][] dirs ={{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if(r == 0){
            return 0;
        }
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='0'){
                    visited[i][j]=true;
                }else{
                    if(!visited[i][j]){
                        islands++;
                        dfs(grid,visited,i,j,islands);
                    }
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][]grid,boolean[][] visited,int curR, int curC,int group){
        if(curR<0 || curR>=grid.length || curC<0 || curC>=grid[0].length || 
        visited[curR][curC]|| grid[curR][curC]=='0'){
            return;
        }
        visited[curR][curC] = true;
        for(int[] dir:dirs){
            int x = curR+dir[0];
            int y = curC+dir[1];
            dfs(grid,visited,x,y,group);
        }
    }
}