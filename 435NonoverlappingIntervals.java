public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;  //first sort by end
                return o2.start - o1.start;  //second sort by start
            }
        };
        Arrays.sort(intervals,comp);

        int end = Integer.MIN_VALUE;
        int count = 0;
        for(Interval interval:intervals){
            if(interval.start>=end) end = interval.end;
            else count++;
        }
        return count;
    }
}