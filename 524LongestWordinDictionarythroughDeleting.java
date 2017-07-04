public class 524LongestWordinDictionarythroughDeleting{
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String str:d){
            if(isSubstring(s,str)){
                if(str.length()>res.length()){
                    res = str;
                }else if(str.length() == res.length()){
                    res = res.compareTo(str)<0? res:str;
                }
            }
        }
        
        return res;
    }
    
    private boolean isSubstring(String s,String str){
        if(str.length()>s.length()){
            return false;
        }
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==str.charAt(start)){
                start++;
            }
            if(start == str.length()){
                return true;
            }
        }
        return start == str.length();
    }
}