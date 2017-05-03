public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if( s2 == null || s1.length()>s2.length()){
            return false;
        }
        boolean diffChar = getCharDiff(s1, s2);
        if(diffChar){
            return false;
        }
        int subLength = s1.length();
        HashSet<String> sub = new HashSet<>();
        for(int i=0; i<= s2.length() - subLength ; i++){
            String sub2 = s2.substring(i,i+subLength);
            if(sub.contains(sub2)){
                continue;
            }else{
                sub.add(sub2);
                HashSet<String> permutation = new HashSet<>(); 
                permutations(sub2,0,subLength-1,permutation);
                if(permutation.contains(s1)){
                        return true;
                }
                
            }

        }
        return false;
    }
    
    private void permutations(String s,int l, int r, HashSet<String> res){
        if(l==r){
            res.add(s);
        }else{
            for(int i=l;i<=r;i++){
                s=swap(s,i,l);
                permutations(s,l+1,r,res);
                s=swap(s,i,l);
            }
        }
    }
    
    private String swap(String s, int i, int j){
        char[] str = s.toCharArray();
        char tmp = str[i];
        str[i] = str[j];
        str[j] =tmp;
        return String.valueOf(str);
        
    }
    
    private boolean getCharDiff(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        HashSet<Character> s2c= new HashSet<>();
        for(int i=0;i<str2.length;i++){
            s2c.add(str2[i]);
        }
        for(int i=0;i<str1.length;i++){
            if(!s2c.contains(str1[i])){
                return true;
            }
        }
        return false;
    }
}