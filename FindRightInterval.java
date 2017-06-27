public class Solution {
    public int[] findRightInterval(Interval[] intervals) {         //TLE  one easy improvement to to use binary search here  binary search is a good friend of sort.
        HashMap<Interval, Integer> index = new HashMap<Interval,Integer>();                   
        if(intervals == null || intervals.length<=1){
            return new int[]{-1};
        }
        int[] res = new int[intervals.length];
        //List<Interval> endInsrc  = new LinkedList<Interval>();
        List<Interval> startInsrc = new LinkedList<Interval>();
        for(int i=0; i<intervals.length;i++){
            index.put(intervals[i],i);
            startInsrc.add(intervals[i]);
        }
        
        Collections.sort(startInsrc,(a,b)->a.start-b.start);
        for(int i=0;i<intervals.length;i++){
            Interval cur = intervals[i];
            Interval minRight = null;
            for(int j=0;j<startInsrc.size();j++){
                if(startInsrc.get(j).start>=cur.end){
                    minRight = startInsrc.get(j);
                    break;
                }
            }
            if(minRight == null) res[i] = -1;
            else res[i] = index.get(minRight);
        }

        return res;
    }
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);    
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }

} 