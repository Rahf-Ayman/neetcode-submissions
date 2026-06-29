class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> a[0] - b[0]);

        List<int []> res = new ArrayList<>();
        res.add(intervals[0]);
        int [] curr;
        for(int i = 1; i < intervals.length;i++){
            curr = intervals[i];
            int [] last = res.getLast();
            if(last[1] >= curr[0] ){
                last[1] = Math.max(curr[1],last[1]); // extend
            }else{
                res.add(curr); // disjoint
            }
        }

        return res.toArray(new int[0][]);
    }
}
