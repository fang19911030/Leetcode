public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length()<10){
            return res;
        }
        Set<String> substring = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i,i+10);
            if(substring.contains(sub)){
                res.add(sub);
            }else{
                substring.add(sub);
            }
        }
        substring.clear();
        for(String tmp: res){
            substring.add(tmp);
        }
        res = new ArrayList<>(substring);
        return res;
    }
}