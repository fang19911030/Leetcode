public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> digit = new LinkedList<>();
        boolean add1 = true;
        for(int r = digits.length-1;r>=0;r--){
            if(add1 == true){
                if(digits[r] == 9){
                    digit.add(0);
                }else{
                    digit.add(digits[r]+1);
                    add1 = false;
                }
            }else{
                digit.add(digits[r]);
            }
        }
        if(add1 == true){
            digit.add(1);
        }
        
        int[] res = new int[digit.size()];
        int index = res.length-1;
        for(int i=0;i<digit.size();i++){
            res[index--] = digit.get(i);
        }
        return res;
    }
}