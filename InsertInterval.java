public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort((a,b)->Integer.compare(a.start, b.start));
        List<Interval> res = new LinkedList<>();
        res.add(intervals.get(0));
        int size = intervals.size();
        for(int i=1;i<size;i++){
            Interval cur = intervals.get(i);
            Interval pre = res.get(res.size()-1);
            if(cur.start<=pre.end){
                pre.end = pre.end>=cur.end? pre.end:cur.end;
            }else{
                res.add(cur);
            }
        }
        return res;
    }
}