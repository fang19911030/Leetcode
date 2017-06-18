/*The graph whether has a cycle, typical question and solution*/ 



public class Solution {
    LinkedList<Integer>[] digraph;      // How to define an array of linkedList
    boolean[] visited;
    boolean[] onStack;
    boolean cycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        digraph = new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++){
            digraph[i] = new LinkedList<>();
        }
        visited = new boolean[numCourses];
        init(prerequisites);
        onStack = new boolean[numCourses];
        for(int v=0;v<numCourses;v++){
            if(visited[v] == false && cycle == false){
                dfs(v);
            }else if(cycle == true){
                return false;
            }
        }
        return true;
    }
    
    private void dfs(int v){
        onStack[v] = true;
        visited[v] = true;
        for(Integer i:digraph[v]){
            if(cycle != false){
                return;
            }else if(!visited[i]){
                dfs(i);
            }else if(onStack[i]){
                cycle = true;
            }
        }
        onStack[v] = false;
    }
    
    private void init(int[][] arr){
        for(int i=0;i<arr.length;i++){
            int course = arr[i][0];
            int pre = arr[i][1];
            digraph[course].add(pre);
        }
    }
    
    
}