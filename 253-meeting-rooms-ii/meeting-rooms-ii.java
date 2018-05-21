// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si &lt; ei), find the minimum number of conference rooms required.
//
// Example 1:
//
//
// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
//
// Example 2:
//
//
// Input: [[7,10],[2,4]]
// Output: 1
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0 || intervals == null){
            return 0;
        }
        int [] start = new int[intervals.length];
        int [] end = new int[intervals.length];
        int j = 0;
        for(Interval i: intervals){
            start[j] = i.start;
            end[j] = i.end;
            j++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int e = 0;
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            if(start[i]<end[e]){
                room++;
            }else{
                e++;
            }
        }
        return room;
    }
}
