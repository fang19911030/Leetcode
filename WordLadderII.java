package algorithms;
import java.util.*;

public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>>graph = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        InitGraph(graph,wordList);
        for(String start:wordList){
        	for(String end:wordList){
        		if(!start.equals(end) && getDiff(start,end)==1){
        			graph.get(start).add(end);
        		}

        	}
        }
        for(String key:graph.keySet()){
        	System.out.print(key+"---->"+graph.get(key)+"\n");
        }
        List<String>tmp = new LinkedList<>();
        tmp.add(beginWord);
        Queue<List<String>> help = new LinkedList<>();
        help.offer(tmp);
        int limit = 0;
        while(!help.isEmpty()){
        	List<String> cur = help.poll();
        	String key = cur.get(cur.size()-1);
        	if(res.size()==0 || cur.size()<=limit){
	        	for(int i=0;i<graph.get(key).size();i++){
	        		List<String> newPath = new LinkedList<>(cur);
	        		String next = graph.get(key).get(i);
	        		if(next == endWord){
	        			List<String> oneres = new LinkedList<>(newPath);
	        			limit = oneres.size();
	        			oneres.add(endWord);
	        			res.add(oneres);
	        		}else{
	        			newPath.add(next);
	        			help.offer(newPath);
	        		}
	        	}
        	}
        }
        return res;
        
    }
    
    private int getDiff(String s1, String s2){
    	char[] str1 = s1.toCharArray();
    	char[] str2 = s2.toCharArray();
    	int diff = 0;
    	for(int i=0;i<str1.length;i++){
    		if(str1[i]!=str2[i]){
    			diff++;
    		}
    	}
    	return diff;
    }
    
    private void InitGraph(Map<String, List<String>> graph, List<String>wordList){
    	if(wordList.size()==0){
    		throw new RuntimeException("Illegal word list");
    	}
    	for(String tmp:wordList){
    		List<String> end = new LinkedList<>();
    		graph.put(tmp, end);
    	}
    	return;
    }
    
    public static void main(String[] args){
    	String s1 = "hit";
    	String s2 = "cog";
    	List<String> wordList = new LinkedList<>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");
    	
    	WordLadder solution = new WordLadder();
    	List<List<String>> res =solution.findLadders(s1, s2, wordList);
    	System.out.print(res);
    }
    
    
    

}