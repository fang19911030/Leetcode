public class Solution {
    private int[] original;
    private int[] shuffle;

    public Solution(int[] nums) {
        original = nums;
        shuffle = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            shuffle[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i= original.length-1;i>=1;i--){
            int j = rand.nextInt(i+1);
            int tmp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = tmp;
        }
        return shuffle;
    }
}