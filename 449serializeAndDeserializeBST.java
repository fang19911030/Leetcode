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

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#");
            return;
        }
        sb.append(root.val+",");
        if(root.left!=null)serialize(root.left, sb);
        if(root.right != null)serialize(root.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;
        String[] states = data.split(",");
        return deserialize(states,0,states.length-1);
    }
    
    private TreeNode deserialize(String[] states,int start, int end){
        if(start == end){
                return new TreeNode(Integer.valueOf(states[start]));
        }
        TreeNode curRoot = new TreeNode(Integer.valueOf(states[start]));
        int leftEnd = start;
        for(int i=start;i<=end;i++){
            if(states[start].compareTo(states[i])>0){
                leftEnd = i;
            }
        }
        if(leftEnd >start)curRoot.left = deserialize(states,start+1,leftEnd);
        if(leftEnd+1<=end) curRoot.right = deserialize(states,leftEnd+1,end);
        return curRoot;
        
    }

    private static final String SEP=",";
    private static final String NULL = "null";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null) return NULL;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            root = st.pop();
            sb.append(root.val).append(SEP);
            if(root.right!= null)st.push(root.right);
            if(root.left != null)st.push(root.left);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        if(data.equals(NULL)) return null;
        String[]strs = data.split(SEP);
        Queue<Integer> q= new LinkedList<>();
        for(String e:strs){
            q.offer(Integer.valueOf(e));
        }
        return getNode(q);
    }

    private TreeNode getNode(Queue<Integer> q){
        if(q.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> left = new LinkedList<>();
        while(!q.isEmpty() && q.peek()<root.val){
            left.offer(q.poll());
        }
        root.left = getNode(left);
        root.right = getNode(q);
        return root;
    }
}