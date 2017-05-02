public class Solution {
    // public TreeNode convertBST(TreeNode root) {
    //     int sum = getSum(root);
    //     Inorder(root,sum);
    //     return root;
    // }
    
    // private int getSum(TreeNode root){
    //     int res = 0;
    //     if(root.left == null && root.right == null){
    //         return res + root.val;
    //     }
    //     res += root.val;
    //     if(root.left != null){
    //         res+=getSum(root.left);
    //     }
    //     if(root.right != null){
    //         res+=getSum(root.rogjt);
    //     }
    //     return res;
    // }
    
    // private void Inorder(TreeNode root, int sum){
    //     Inorder(root.left, sum);
    //     int tmp = root.val;
    //     root.val = sum;
    //     sum-=tmp;
    //     Inorer(root.right,sum);
    // }

    public TreeNode convertBST(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        int[] sum = {getSum(root)};
        Inorder(root,sum);
        return root;
    }
    
    private int getSum(TreeNode root){
        int res = 0;
        if(root.left == null && root.right == null){
            return res + root.val;
        }
        res += root.val;
        if(root.left != null){
            res+=getSum(root.left);
        }
        if(root.right != null){
            res+=getSum(root.right);
        }
        return res;
    }
    
    private void Inorder(TreeNode root, int[] sum){
        if(root == null){
            return;
        }
        Inorder(root.left, sum);
        int tmp = root.val;
        root.val = sum[0];
        sum[0]-=tmp;
        Inorder(root.right,sum);
    }
}