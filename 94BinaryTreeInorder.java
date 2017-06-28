public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new LinkedList<Integer>();
    	if (root == null) return res;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while (cur != null || !stack.isEmpty()) { 
    		while (cur != null) {// Travel to each node's left child, till reach the left leaf
    	        //res.add(cur.val);   midorder
    			stack.push(cur);
    			cur = cur.left;				
    		}		 
    		cur = stack.pop(); // Backtrack to higher level node A
    		res.add(cur.val);  // Add the node to the result list
    		cur = cur.right;   // Switch to A'right branch
    	}
    	return res;
    }
}