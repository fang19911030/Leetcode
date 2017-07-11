public class Solution{
	class Node {
	    int val, cnt;
	    Node left, right;
	        
	    Node(int val) {
	        this.val = val;
	        this.cnt = 1;
	    }
	}
	private int search(Node root, long val) {
	    if (root == null) {
	    	return 0;
	    } else if (val == root.val) {
	    	return root.cnt;
	    } else if (val < root.val) {
	    	return root.cnt + search(root.left, val);
	    } else {
	    	return search(root.right, val);
	    }
	}

	private Node insert(Node root, int val) {
	    if (root == null) {
	        root = new Node(val);
	    } else if (val == root.val) {
	        root.cnt++;
	    } else if (val < root.val) {
	        root.left = insert(root.left, val);
	    } else {
	        root.cnt++;
	        root.right = insert(root.right, val);
	    }
	    
	    return root;
	}

	public int reversePairs(int[] nums) {
	    int res = 0;
	    Node root = null;
	    	
	    for (int ele : nums) {
	        res += search(root, 2L * ele + 1);
	        root = insert(root, ele);
	    }
	    
	    return res;
	}

	public int reversePairs(int[] nums) {
	    return reversePairsSub(nums, 0, nums.length - 1);
	}
    
	private int reversePairsSub(int[] nums, int l, int r) {
	    if (l >= r) return 0;
	        
	    int m = l + ((r - l) >> 1);
	    int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);
	        
	    int i = l, j = m + 1, k = 0, p = m + 1;
	    int[] merge = new int[r - l + 1];
	        
	    while (i <= m) {
	        while (p <= r && nums[i] > 2L * nums[p]) p++;
	        res += p - (m + 1);
	        	
	        while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
	        merge[k++] = nums[i++];
	    }
	        
	    while (j <= r) merge[k++] = nums[j++];
	        
	    System.arraycopy(merge, 0, nums, l, merge.length);
	        
	    return res;
	}
	
}