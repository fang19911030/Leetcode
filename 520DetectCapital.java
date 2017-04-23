public class Solution {
    public boolean detectCapitalUse(String word) {
        int[] help = new int[word.length()];
        int length = word.length();
        for(int i=0;i<length;i++){
            help[i]=word.charAt(i)-'a';
        }
//         if(AllCapital(help)){
//             return true;
//         }
//         if(firstCapital(help)){
//             return true;
//         }
//         if(NonCapital(help)){
//             return true;
//         }
//         return false;
        if(help[0]<0){
            if(AllCapital(help)){
                return true;
            }
            if(firstCapital(help)){
                return true;
            }
        }else{
            if(NonCapital(help)){
                return true;
            }
        }
        return false;                   
    }
    
    private boolean AllCapital(int[]help){
        for(int i =0;i<help.length;i++){
            if(help[i]>=0){
                return false;
            }
        }
        return true;
    }
    
    private boolean firstCapital(int[]help){
        boolean position1 = help[0]>=0? false:true;
        boolean position2 = true;
        for(int i=1;i<help.length;i++){
            if(help[i]<0){
                position2 = false;
                break;
            }
        }
        return position1&position2;
    }
    
    private boolean NonCapital(int[]help){
        for(int i=0;i<help.length;i++){
            if(help[i]<0){
                return false;
            }
        }
        return true;
    }
}
