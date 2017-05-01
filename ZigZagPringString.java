public class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int magic = numRows *2 -2;                  //here is the core part
        int initialDistance = magic;
        for(int i=0; i< numRows; i++){
            fill(sb, i, initialDistance, magic, s);
            initialDistance = initialDistance -2;
        }
        return sb.toString();
    }
    
    public void fill(StringBuilder sb, int start, int initialDistance, int magic, String s){
        while(start<s.length()){
            if(initialDistance == 0){
                initialDistance = magic;
            }
            sb.append(s.charAt(start));
            start = start + initialDistance;
            initialDistance = magic - initialDistance;
        }
    }
}