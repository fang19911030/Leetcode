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
}