public class RandomizedSet {
    private List<Integer> nums;
    HashMap<Integer, Integer>locs;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locs.containsKey(val)){
            return false;
        }else{
            nums.add(val);
            locs.put(val,nums.size()-1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(locs.containsKey(val)){
            //int last = nums.get(nums.size()-1);
            int index = locs.get(val);
            if(index< nums.size()-1){
                int last = nums.get(nums.size()-1);
                nums.set(index,last);
                locs.put(last,index);
            }
            locs.remove(val);
            nums.remove(nums.size()-1);
            return true;
        }else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */