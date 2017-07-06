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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val+",");
        serialize(root.left, sb);
        serialize(root.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] states = data.split(",");
        return deserialize(states,0,states.length-1);
    }
    
    private TreeNode deserialize(String[] states,int start, int end){
        if(start == end){
            if(states[start].equals("#")){
                return null;
            }else{
                return new TreeNode(Integer.valueOf(states[start]));
            }
        }
        TreeNode curRoot = new TreeNode(Integer.valueOf(states[start]));
        int leftEnd = start+1;
        for(int i=start+1;i<=end;i++){
            if(!states[i].equals("#") &&states[start].compareTo(states[i])<0){
                leftEnd = i-1;
                break;
            }
        }
        curRoot.left = deserialize(states,start+1,leftEnd);
        curRoot.right = deserialize(states,leftEnd+1,end);
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
        return sb.toString;
    }

    public TreeNode deserialize(String data){
        if(data.equals(NULL)) return null;
        String[]strs = data.split(SEP);
        Queue<Integer> = new LinkedList<>();
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