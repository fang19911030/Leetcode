public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n<0){
            return res;
        }
        List<String> help = new LinkedList<String>();
        for(int i=1;i<=n;i++){
            help.add(String.valueOf(i));
        }
        Collections.sort(help);
        for(String num:help){
            res.add(Integer.valueOf(num));
        }
        return res;
    }
}