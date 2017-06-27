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
    public int[] findRightInterval2(Interval[] intervals) {
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

    public int[] findRightInterval3(Interval[] intervals) {
        int [] answer = new int [intervals.length];
        List<int[]> sortedIntervals = new ArrayList<>();
        
        for (int idx = 0; idx < intervals.length; idx ++)
            sortedIntervals.add(new int[] { intervals [idx].start, idx });
        
        Collections.sort (sortedIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1 [0] - o2 [0];
            }
        });
        
        for (int idx = 0; idx < intervals.length; idx ++) {
            int search = intervals [idx].end;
            int low = 0, high = sortedIntervals.size() - 1;
            boolean found = false;
            
            int mid = -1;
            while (low <= high) {
                mid = (low + high) >>> 1;
                if (sortedIntervals.get(mid)[0] > search)
                    high = mid - 1;
                else if (sortedIntervals.get(mid)[0] < search)
                    low = mid + 1;
                else {
                    answer[idx] = sortedIntervals.get(mid)[1];
                    found = true; break;
                }
            }

            answer[idx] = (!found) ? (low < sortedIntervals.size() && high < sortedIntervals.size() ? sortedIntervals.get(low)[1] : -1) : answer[idx];
        }
        
        return answer;
    }

} 