/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Interval curr : intervals){
            if(!queue.isEmpty() && queue.peek() <= curr.start){
                queue.poll();
            }
            queue.add(curr.end);
        }
        return queue.size();
    }
}
