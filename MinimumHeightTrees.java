public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List[]graph = new List[n];
        for(int i=0;i<n;i++){
            graph[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<edges.length;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            boolean[] visited= new boolean[n];
            int[] dist =new int[n];
            heights[i] = bfs(graph,i,visited,dist);
        }
        List<Integer> res = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        for(Integer i:heights){
            minHeight = Math.min(i,minHeight);
        }
        for(int i=0;i<heights.length;i++){
            if(heights[i]==minHeight){
                res.add(i);
            }
        }
        return res;
    }
    
    private int bfs(List<Integer>[] graph,int start,boolean[]visited,int[] dist){
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            int size = graph[node].size();
            int i = 0;
            while(i<size){
                int next = graph[node].get(i);
                if(visited[next] == false){
                    dist[next] = dist[node]+1;
                    queue.offer(next);
                }
                i++;
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<dist.length;i++){
            res = Math.max(res,dist[i]);
        }
        return res;
    }
    

}