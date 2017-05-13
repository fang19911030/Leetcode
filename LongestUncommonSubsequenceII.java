public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(s1,s2)->s2.length() - s1.length());
        for(int i=0;i<strs.length;i++){
            int sub = strs.length;
            for(int j=0;j<strs.length;j++){
                if(i!= j && isSub(strs[i],strs[j])){
                    break;
                }else{
                    sub--;
                }
            }
            if(sub == 0){
                return strs[i].length();
            }
        }
        return -1;
    }
    
    public boolean isSub(String s1, String s2){
        int common = 0;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        if(str1.length>str2.length){
            return false;
        }else{
            for(int i=0;i<str2.length && common<str1.length;i++){
                if(str2[i]==str1[common]){
                    common++;
                }
            }
            return common==str1.length;
        }
    }
}