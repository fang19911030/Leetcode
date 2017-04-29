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
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        int[] res = new int[2];
        res[1] = 1;
        res[0] = root.val;
        return dfs(root,1,res);
    }
    
    private int dfs(TreeNode root, int depth, int[]res){
        if(depth>res[1]){
            res[1] = depth;
            res[0] =root.val;
        }
        if(root.left != null){
            dfs(root.left,depth+1,res);
        }
        if(root.right != null){
            dfs(root.right, depth+1,res);
        }
        return res[0];
    }
}