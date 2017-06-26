public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            int[] nums = new int[10];
            for(int j=0;j<c;j++){
                if(board[i][j]!='.') nums[board[i][j]-'0']++;
            }
            for(int x=0;x<nums.length;x++){
                if(nums[x]>1 || nums[0]!=0){
                    return false;
                }
            }
        }
        for(int j=0;j<c;j++){
            int[] nums= new int[10];
            for(int i=0;i<r;i++){
                if(board[i][j]!='.') nums[board[i][j]-'0']++;
            }
            for(int x=0;x<nums.length;x++){
                if(nums[x]>1 || nums[0]!=0){
                    return false;
                }
            }
        }
        
        for(int i=0;i+3<=r;i+=3){
            for(int j=0;j+3<=c;j+=3){
                int[]start = {i,j};
                int[]end ={i+3,j+3};
                if(!isValid(board,start,end)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][]board,int[]start,int[] end){
        int[]nums=new int[10];
        for(int i=start[0];i<end[0];i++){
            for(int j=start[1];j<end[1];j++){
                if(board[i][j]!='.') nums[board[i][j]-'0']++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[0]!=0 || nums[i]>1){
                return false;
            }
        }
        return true;
    }
}