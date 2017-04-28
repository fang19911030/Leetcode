/**
 * Created by fang on 4/28/17.
 */
import java.util.*;
public class ZumaGame {
    public int findMinStep(String board, String hand) {                 //not correct
        if(board == null || board.length()==0){
            return 0;
        }

        Stack<String> help = new Stack<>();
        help.push(board);
        int res = -1;
        for(int i=0;i<hand.length();i++){
            Stack<String> newStack = new Stack<>();
            while(!help.isEmpty()){
                String cur = help.pop();
                //String add = "";
                String newAdd = String.valueOf(hand.charAt(i));
                for(int j=0;j<=cur.length();j++)
                {
                    String add ="";
                    if(j==0){
                        add = newAdd+ cur;
                    }else if(j == cur.length()){
                        add = cur + newAdd;
                    }else{
                        add = cur.substring(0,j) + newAdd + cur.substring(j);
                    }
                    if(canClean(add)){
                        res = i;
                        return res;
                    }else{
                        newStack.push(add);
                    }
                }
            }
            help = newStack;
        }
        return -1;
    }

    private boolean canClean(String str){
        if(str.length()%3!=0){
            return false;
        }
        String cur = str;
        while(!cur.equals("")){
            int[] start = find(cur);
            if(start[0] == -1){
                return false;
            }else{
                String newCur = cur.substring(0,start)+cur.substring(start+3);
                cur = newCur;
            }
        }
        return true;
    }

    private int[] find(String str){
        char[] s = str.toCharArray();
        int[]res = new int[2];
        res[0] = -1;
        int i=0;
        int length=1;
        while(i<s.length-1){
            if(s[i] == s[i+1]){
                length++;
                i++;
            }
        }

        return -1;
    }

    int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    public int findMinStep2(String board, String hand) {
        int[] handCount = new int[32];
        for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
        int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;
    }
    private int helper(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int  rs = MAXCOUNT, need = 0;
        for (int i = 0, j = 0 ; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);     //balls need to remove current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }
    //remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }

    public static void main(String[]args){
        String testCanClean="caabbddbacce";
        ZumaGame solution = new ZumaGame();
//        System.out.println(solution.canClean(testCanClean));
        String s1 = "wwrrbbww";
        String s2 = "wrbrw";
        int res = solution.findMinStep(s1,s2);
        System.out.println(res);
    }
}
