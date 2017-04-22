/**
 * Created by fang on 4/22/17.
 */
import java.util.*;

public class MergeIntervals {
      public static class Interval {
          public int start;
          public int end;


          public Interval(int s, int e) {
              start = s;
              end = e;
          }
      }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if(intervals.size()==0){
            return res;
        }
        sort(intervals);
        Interval start = new Interval(intervals.get(0).start,intervals.get(0).end);
        res.add(start);
        for(int i=1;i<intervals.size();i++){
            Interval next = intervals.get(i);
            Interval pre = res.get(res.size()-1);
            if(pre.end>=next.start){
                pre.end =  pre.end>next.end? pre.end:next.end;
                continue;
            }
            Interval newElem = new Interval(next.start,next.end);
            res.add(newElem);
        }
        return res;
    }

    private void sort(List<Interval> intervals){
        for(int i=0;i<intervals.size();i++){
            for(int j=i+1;j<intervals.size();j++){
                Interval pre = intervals.get(i);                      //the slection sort here should pay attentation
                Interval next = intervals.get(j);
                if(pre.start>next.start){
                    Collections.swap(intervals, i, j);
                }
            }
        }
    }

    private void quicksort(List<Interval> intervals,int s, int e){
        if(s<e){
            int index = partition(intervals,s,e);
            quicksort(intervals,s,index-1);
            quicksort(intervals,index+1,e);
        }
    }

    private int partition(List<Interval>intervals,int s, int e){
        Interval pivot = intervals.get(e);
        int l = s-1;
        for(int i=s;i<e;i++){
            if(intervals.get(i).start<=pivot.start){
                l++;
                Collections.swap(intervals,i,l);
            }
        }
        Collections.swap(intervals,l+1,e);
        return l+1;
    }

    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));                  
        
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

//    public static void main(String[] args){
//          List<Interval> intervals = new LinkedList<>();
//          MergeIntervals solution = new MergeIntervals();
//          Interval one = new Interval(1,3);
//          intervals.add(one);
//          Interval two = new Interval(2,6);
//          Interval three = new Interval(7,10);
//          Interval four = new Interval(8,12);
//
//          intervals.add(two);
//          intervals.add(three);
//          intervals.add(four);
//          List<Interval> res = solution.merge(intervals);
//          for(int i=0;i<res.size();i++){
//              System.out.print(res.get(i).start+" "+res.get(i).end+" ");
//          }
//
//    }
}

