class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); //(len , ith)
        List<int []> events = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            events.add(new int []{intervals[i][0] ,0,intervals[i][1] - intervals[i][0] + 1,i });
            events.add(new int []{intervals[i][1] ,2,intervals[i][1] - intervals[i][0] + 1,i });
        }

        for(int i = 0; i < queries.length;i++){
            events.add(new int []{queries[i],1,i});
        }
        boolean [] inactive = new boolean[intervals.length];
        
        // sort time , query before end
        events.sort( (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int [] ans = new int [queries.length];
        Arrays.fill(ans , -1);
        
        for(int [] event : events){
            if(event[1] == 0){
                minHeap.add(new int []{event[2] ,event[3]});
            }else if(event[1] == 2){
                inactive[event[3]] = true;
            }else{
                while(!minHeap.isEmpty() && inactive[minHeap.peek()[1]]){
                    minHeap.poll();
                }
                if(!minHeap.isEmpty())
                ans[event[2]] = minHeap.peek()[0];
            }
        }
        
        return ans;
    }
}
