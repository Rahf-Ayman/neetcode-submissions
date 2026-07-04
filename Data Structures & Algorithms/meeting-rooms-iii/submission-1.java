class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings ,(a ,b) -> a[0] - b[0]);
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        PriorityQueue<long []>  busyRooms = new PriorityQueue<>((a,b) ->
                a[0] != b[0]? Long.compare(a[0] ,b[0]) : Long.compare(a[1] ,b[1])); // [end , room]

        int [] freq = new int[n];
        for (int i = 0; i < n; i++) {
            emptyRooms.offer(i);
        }
        for(int [] meeting : meetings){
            long start = (long) meeting[0];
            long end = (long) meeting[1];
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= start){
                int room = (int) busyRooms.poll()[1];
                emptyRooms.offer(room);
            }

            if(emptyRooms.isEmpty()){
                long [] curr = busyRooms.poll();
                end = curr[0] + (end - start);
                emptyRooms.offer((int) curr[1]);
            }

            int room = emptyRooms.poll();
            busyRooms.offer(new long []{end , room});
            freq[room]++;
        }
        
        int minRoom = 0;
        for(int i = 0; i < n;i++){
            if(freq[i] > freq[minRoom]){
                minRoom = i;
            }
        }
        return minRoom;
    }
}