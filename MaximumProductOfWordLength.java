public class Solution {
    public int maxProduct(String[] words) {
        int res =0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isValid(words[i],words[j])){
                    res = Math.max(words[i].length()*words[j].length(), res);
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s1, String s2){
        boolean[] str1 = new boolean[26];
        boolean[] str2 = new boolean[26];
        for(int i=0;i<s1.length();i++){
            str1[s1.charAt(i)-'a'] = true;
        }
        for(int j=0; j<s2.length();j++){
            str2[s2.charAt(j)-'a'] = true;
        }
        for(int i=0;i<26;i++){
            if(str1[i]==true && str2[i]==true){
                return false;
            }
        }
        return true;
        
    }

    //imporvement

    public static int maxProduct2(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');  // int is 32 bit no overflow
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        }
        return maxProduct;
    }
}