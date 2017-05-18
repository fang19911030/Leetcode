public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                res.add(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        
        return res;
    }
/*     when find a number i, flip the number at position i-1 to negative.  1 =<nums[i]<=n(n size of array)
     if the number at position i-1 is already negative, i is the number that occurs twice.*/
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}