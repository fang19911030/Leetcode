public class Solution {
    public String reverseVowels(String s) {
        if(s== null || s.length()<=1){
            return s;
        }
        int left = 0;
        int right = s.length()-1;
        Set<Character> vowel = new HashSet<>();
        char[]vowels = {'a','e','i','o','u'};
        for(char c:vowels){
            vowel.add(c);
            vowel.add(Character.toUpperCase(c));
        }

        
        char[] str = s.toCharArray();
        while(left<right){
            char l = str[left];
            char r = str[right];
            if(vowel.contains(l) && vowel.contains(r)){
                swap(str,left,right);
                left++;
                right--;
            }else if(vowel.contains(l)){
                right--;
            }else if(vowel.contains(r)){
                left++;
            }else{
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }
    private void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}