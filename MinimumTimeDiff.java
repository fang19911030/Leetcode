public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<Integer>();
        transform(times,timePoints);
        Collections.sort(times);
        int res = Integer.MAX_VALUE;       
        for(int i=1;i<times.size();i++){
            res = Math.min(res,times.get(i)-times.get(i-1));
        }
        res = Math.min(res,times.get(0)+(1440-times.get(times.size()-1)));   //MOst Importpart of this question
        return res;
    }
    private void transform(List<Integer> times,List<String>list){
        for(int i=0;i<list.size();i++){
            String[] time = list.get(i).split(":");
            times.add(Integer.parseInt(time[0])*60+Integer.parseInt(time[1]));
        }
    }
}