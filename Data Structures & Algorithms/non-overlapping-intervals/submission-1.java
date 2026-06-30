class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> a[1] - b[1]);

        int keep = 0;
        int lastend = Integer.MIN_VALUE;

        for(int i = 0; i < intervals.length; i++){
            int [] curr = intervals[i];
            if(curr[0] >= lastend){
                keep++;
                lastend = curr[1];
            }
        }
        return intervals.length - keep;
    }
}
