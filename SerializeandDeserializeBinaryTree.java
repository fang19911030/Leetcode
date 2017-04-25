/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode head) {
        if(head == null){
            return "#! ";
        }
        String res = head.val+"! ";
        res += serialize(head.left);
        res += serialize(head.right);
        return res;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split("! ");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<value.length;i++){
            queue.offer(value[i]);
        }
        return reconPreOrder(queue);
        
    }
    private TreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));