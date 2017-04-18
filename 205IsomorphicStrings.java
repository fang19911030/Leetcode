public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s== null || t==null || s.length()!= t.length()){
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<str1.length;i++){
            if(!map.containsKey(str1[i])){
                map.put(str1[i],str2[i]);
            }else{
                char last = map.get(str1[i]);
                if(last!= str2[i]){
                    return false;
                }
            }
        }
        map.clear();
        for(int i=0;i<str2.length;i++){
            if(!map.containsKey(str2[i])){
                map.put(str2[i],str1[i]);
            }else{
                char last = map.get(str2[i]);
                if(last!= str1[i]){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}