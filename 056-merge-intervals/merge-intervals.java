// Given a collection of intervals, merge all overlapping intervals.
//
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].
//


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });
        if (intervals.size() <= 1){
            return intervals;
        }
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals){
            if(interval.start<=end){
                end = Math.max(end, interval.end);
            }else{
                result.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
