public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(needle == null){
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        
        int length1 = haystack.length();
        int length2 = needle.length();
        for(int i=0;i<=length1-length2;i++){
            if(haystack.substring(i,i+length2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
