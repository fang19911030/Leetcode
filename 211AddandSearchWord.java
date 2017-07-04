public class 211AddandSearchWord{
    class Node{
        Node[] children;
        boolean end;
        public Node(){
            children = new Node[26];
        }
    }
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(root,word, 0);
    }
    
    private void addWord(Node x, String word, int d){
        if(d == word.length()){
          if(x != null){
              x.end = true;
              return;
          }  
        } 
        char c = word.charAt(d);
        if(x.children[c-'a'] == null){
            x.children[c-'a'] = new Node();
            addWord(x.children[c-'a'],word,d+1);
        }else{
            addWord(x.children[c-'a'],word,d+1);
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word,0);
    }
    
    private boolean search(Node x, String word, int d){             //key part
        if(x == null) return false;
        if(d == word.length() && x.end) return true;
        if(d == word.length()) return false;
        char c = word.charAt(d);
        if(c=='.'){
            boolean res = false;
            for(int i=0;i<x.children.length;i++){
                if(x.children[i]!=null){
                    res = res || search(x.children[i],word,d+1);
                }
            }
            return res;
        }else{
            boolean res= true;
            res = res & search(x.children[word.charAt(d)-'a'],word,d+1);
            return res;
        }

    }
}