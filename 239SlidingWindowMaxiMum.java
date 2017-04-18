import java.util.*;

public class MaximumOfSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k){
		if(nums == null || nums.length==0){
			return nums;
		}
		if(k>=nums.length){
		   int res = Integer.MIN_VALUE;
		   for(int i=0;i<nums.length;i++){
			   res = Math.max(res, nums[i]);
		   }
		   return new int[]{res};
		}
		int[] res = new int[nums.length-k+1];
		int index=0;
		Deque<Integer>deque = new LinkedList<>();
		for(int i=0;i<nums.length 
				;i++){
			while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
				deque.removeLast();
			}
			deque.addLast(i);
			int maxIndex = deque.peekFirst();
			if(maxIndex == i-k){
				deque.removeFirst();
			}
			if(i>=k-1){
				res[index++] = nums[deque.peekFirst()];
			}


		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums= {1,3,-1,-3,5,3,6,7};
		int k =3;
		MaximumOfSlidingWindow solution = new MaximumOfSlidingWindow();
		int [] res = solution.maxSlidingWindow(nums,k);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" ");
		}
	}

}