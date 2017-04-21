public class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        
        for(int i=0;i<nums.length;i++){
            if(s.charAt(i)=='I'){
                nums[i]=1;
            }else if(s.charAt(i)=='V'){
                nums[i] = 5;
            }else if(s.charAt(i) == 'X'){
                nums[i] = 10;
            }else if(s.charAt(i) == 'L'){
                nums[i] = 50;
            }else if(s.charAt(i) == 'C'){
                nums[i] = 100;
            }else if(s.charAt(i) == 'D'){
                nums[i] = 500;
            }else if(s.charAt(i) == 'M'){
                nums[i] = 1000;
            }else{
                return -1;
            }
        }
        
        int res =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                res += nums[i];
            }else{
                res-= nums[i];
            }
        }
        return res+nums[nums.length-1];
    }

    public int romanToInt2(String s){
        int res = 0;
        Map<Character, Integer> tabel = new HashMap<>();
        tabel.put('I',1);
        tabel.put('V',5);
        tabel.put('X',10);
        tabel.put('L',50);
        tabel.put('C',100);
        tabel.put('D',500);
        tabel.put('M',1000);

        for(int i=0;i<s.length()-1;i++){
            int pre = tabel.get(s.charAt(i));
            int next = tabel.get(s.charAt(i+1));
            if(pre>=next){
                res+=pre;
            }else{
                res-=pre;
            }
        }
        res+=tabel.get(s.charAt(s.length()-1));
        return res;
    }
}