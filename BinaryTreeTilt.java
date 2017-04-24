/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int findTilt(TreeNode root) {
        if(root== null || root.left == null && root.right == null){
            return 0;
        }
        int[] res=new int[1];
        postorder(root, res);
        return res[0];
        
    }
    
    private int postorder(TreeNode root, int[] res){
        if(root == null){
          return 0; 
        } 
        int left = postorder(root.left, res);
        int right = postorder(root.right, res);
        res[0]+= Math.abs(left-right);
        return left+right+root.val;
        
    }
}