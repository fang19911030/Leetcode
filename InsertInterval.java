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
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++)); 
        return result;
    }
}