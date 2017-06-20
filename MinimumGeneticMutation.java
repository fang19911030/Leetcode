public class Solution {
    HashMap<String,List<String>> graph;
    Set<String> strInBank;
    public int minMutation(String start, String end, String[] bank) {
        graph = new HashMap<>();
        strInBank = new HashSet<>();
        init(bank);
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        Set<String> visited = new HashSet<>();
        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(end,0);
        visited.add(end);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(isOneDiff(cur,start) && strInBank.contains(cur)){
                res=dist.get(cur)+1;
                return res;
            }
            if(!graph.containsKey(cur)){
                return -1;
            }
            for(String next:graph.get(cur)){
                if(!visited.contains(next)){
                    queue.offer(next);
                    dist.put(next,dist.get(cur)+1);
                    visited.add(next);
                }
            }
        }
        return -1;
    }
    
    private boolean isOneDiff(String str1, String str2){
        if(str1.length()!= str2.length()){
            return false;
        }
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diff++;
            }
        }
        
        return diff==1;
    }
    
    private void init(String[] strs){
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs.length;j++){
                if(isOneDiff(strs[i],strs[j])){
                    if(graph.containsKey(strs[i])){
                        graph.get(strs[i]).add(strs[j]);
                    }else{
                        List<String> tmp = new LinkedList<>();
                        tmp.add(strs[j]);
                        graph.put(strs[i],tmp);
                    }
                }
            }
            strInBank.add(strs[i]);
        }
    }

    public int minMutation2(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        
        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}