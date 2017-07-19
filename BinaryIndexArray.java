public class NumArray{
	int[] BIT;
	int n;
	int[]nums;

	public NumArray(int[] nums){
		this.nums = nums;
		this.n = nums.length;
		BIT = new int[n+1];

		for(int i=0;i<nums.length;i++){
			init(i,nums[i]);
		}
	}

	public void init(int i,int val){
		i++;
		while(i<n){
			BIT[i] += val;
			i +=(i&-i);
		}
	}

	public int getSum(int i){
		int res = 0;
		i++;
		while(i>0){
			res += BIT[i];
			i -= (i&-i);
		}


	}
}