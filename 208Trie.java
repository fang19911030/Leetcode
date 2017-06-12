public class Trie {

    class TrieNode{
        public TrieNode[] index;
        int end;
        char key;
        
        public TrieNode(){
            end = 0;
            index = new TrieNode[26];
            Arrays.fill(index,null);
        }
        
        public TrieNode(char key){
            end = 0;
            index = new TrieNode[26];
            Arrays.fill(index,null);
            this.key = key;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        char[] str = word.toCharArray();
        TrieNode node = root;
        for(int i=0;i<str.length;i++){
            int idx = str[i]-'a';
            if(node.index[idx]== null){
                node.index[idx] = new TrieNode(str[i]);
            }
            node = node.index[idx];
        }
        node.end++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word== null || word.length() == 0){
            return true;
        }
        TrieNode node = root;
        char[] str = word.toCharArray();
        for(int i=0;i<str.length ; i++){
            int idx = str[i]-'a';
            if(node.index[idx] == null){
                return false;
            }
            node = node.index[idx];
        }
        return node.end>0;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length()==0){
            return true;
        }
        char[] str = prefix.toCharArray();
        TrieNode node = root;
        for(int i=0 ; i<str.length ; i++){
            int idx = str[i]-'a';
            if(node.index[idx] == null){
                return false;
            }
            node = node.index[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */