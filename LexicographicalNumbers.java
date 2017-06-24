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

    public List<Integer> lexicalOrder(int n){
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n,res);
        }
        return res;
    }

    private void dfs(int cur, int n,List<Integer> res){
        if(cur>n){
            return;
        }else{
            res.add(cur);
            for(int i=0;i<10;i++){
                if(10*cur+i>n){
                    return;
                }
                dfs(10*cur+i,n,res);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}