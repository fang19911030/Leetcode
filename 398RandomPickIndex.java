public class Solution {
    HashMap<Integer,List<Integer>> valueIndex;
    Random rand;

    public Solution(int[] nums) {
        valueIndex = new HashMap<Integer,List<Integer>>();
        rand = new Random();
        for(int i=0;i<nums.length;i++){
            if(valueIndex.containsKey(nums[i])){
                valueIndex.get(nums[i]).add(i);
            }else{
                List<Integer> tmp = new LinkedList<Integer>();
                tmp.add(i);
                valueIndex.put(nums[i],tmp);
            }
        }
        
    }
    
    public int pick(int target) {
        if(!valueIndex.containsKey(target)){
            return -1;
        }else{
            List<Integer> index = valueIndex.get(target);
            return index.get(rand.nextInt(index.size()));
        }
        
    }
}