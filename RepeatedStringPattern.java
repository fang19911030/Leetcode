public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s== null || s.length()==0){
            return false;
        }
        int length = s.length();
        
        for(int i=1;i<length;i++){
        	if(length%i==0){
                String pattern = s.substring(0,i);
                if(hasPattern(s,pattern)){
                    return true;
                }
        	}
        }
        return false;
    }
    
    private boolean hasPattern(String s, String pattern){
        //System.out.print("Pattern length: "+ pattern.length()+" ");
        
        for(int i=0;i<=s.length()-pattern.length();i+=pattern.length()){
            String sub = s.substring(i,i+pattern.length());
            if(!sub.equals(pattern)){
                return false;
            }

        }
        return true;
    }
}