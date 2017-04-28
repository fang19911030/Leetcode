public class Solution {
    public boolean checkRecord(String s) {
        if(s==null ||s.length()<=1){
            return true;
        }
        
        char[] str = s.toCharArray();
        return help(str,0,0,0);
    }
    
    private boolean help(char[] str, int index, int abs, int l){
        if(index>=str.length && abs<=1 && l<=2){
            return true;
        }
        if(abs>1){
            return false;
        }
        if(l>2){
            return false;
        }
        boolean res;
        if(str[index]=='A'){
            l=0;
            res = help(str,++index,++abs,l);
        }else if(str[index]=='P'){
            l=0;
            res = help(str,++index,abs,l);
        }else{
            res = help(str,++index,abs,++l);
        }
        return res;
    }
}