public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int curres = Integer.MIN_VALUE;
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                curres = Math.max(curres,cur.val);
                if(cur.left!= null) nextLevel.offer(cur.left);
                if(cur.right!= null) nextLevel.offer(cur.right);
            }
            res.add(curres);
            queue = nextLevel;
        }
        return res;
    }
}