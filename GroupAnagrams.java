public class Solution {
    public boolean[] visited;
    public List<List<String>> res;
    public List<List<String>> groupAnagrams(String[] strs) {
        res = new LinkedList<List<String>>();
        if(strs.length==0){
            return res;
        }
        visited = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(visited[i]) continue;
            List<String> curGroup = new LinkedList<String>();
            curGroup.add(strs[i]);
            visited[i] = true;
            for(int j=i+1;j<strs.length;j++){
                if(visited[j]) continue;
                if(strs[i].length()!=strs[j].length()){
                    continue;
                }else if(sameCharacter(strs[i],strs[j]) && sameCharacter(strs[j],strs[i])){
                    curGroup.add(strs[j]);
                    visited[j]=true;
                }
            }
            res.add(curGroup);
        }
        return res;
    }  // Cant pass all the test case-

    private boolean sameCharacter(String str1, String str2){
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<str1.length();i++){
            set.add(str1.charAt(i));
        }
        for(int i=0;i<str2.length();i++){
            if(!set.contains(str2.charAt(i))){
                return false;
            }
        }
        return true;

    }


    // public List<List<String>> groupAnagrams2(String[] strs) {
    //     if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
    //     Map<String, List<String>> map = new HashMap<String, List<String>>();
    //     for (String s : strs) {
    //         char[] ca = s.toCharArray();
    //         Arrays.sort(ca);
    //         String keyStr = String.valueOf(ca);
    //         if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
    //         map.get(keyStr).add(s);
    //     }
    //     return new ArrayList<List<String>>(map.values());
    // }
        public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        //Arrays.sort(strs);
        for (String s:strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        
    //  for(String key: map.keySet()) {
    //      Collections.sort(map.get(key));
    //  }
        return new ArrayList<List<String>>(map.values());
    }
}