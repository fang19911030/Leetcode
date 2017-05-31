/**
 * Created by fang on 5/31/17.
 */
public class SurrondedRegion {
    public void solve(char[][] board) {
        if(board.length<=2||board[0].length<=2){
            return;
        }
        int r = board.length;
        int col = board[0].length;
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[r-1][i]=='O'){
                dfs(board,r-1,i);
            }

        }
        for(int i=0;i<r;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][col-1]=='O'){
                dfs(board,i,col-1);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }


    }

    private void dfs(char[][]board,int r, int c){
        int br = board.length;
        int bc = board[0].length;
        if(r<0 || r>=br ||c<0 || c>=bc){
            return;
        }
        board[r][c] = '*';
        if(r-1>=1 && board[r-1][c]=='O'){                                     //the boundary needn't see again avoid one unnecessry call 
            dfs(board,r-1,c);
        }
        if(r+1<br-1 && board[r+1][c]=='O'){
            dfs(board,r+1,c);
        }
        if(c-1>=1 && board[r][c-1]=='O'){
            dfs(board,r,c-1);
        }
        if(c+1<bc-1 && board[r][c+1]=='O'){
            dfs(board,r,c+1);
        }
    }

    public static void main(String[] args){
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurrondedRegion solution = new SurrondedRegion();
        solution.solve(board);
    }

}
