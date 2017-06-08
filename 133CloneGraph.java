/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode cloneNode(UndirectedGraphNode node){
    	if(node == null){
    		return null;
    	}
    	if(map.containsKey(node.label)){
    		return map.get(node.label);
    	}

    	UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    	map.put(node.label,clone);
    	for(UndirectedGraphNode neigh:node.neighbors){
    		clone.neighbors.add(cloneNode(neigh));
    	}
    	return clone;
    }
}