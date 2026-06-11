class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0;i < hand.length;i++){
            hashMap.put(hand[i], hashMap.getOrDefault(hand[i],0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(hashMap.keySet());

        while(!heap.isEmpty()){
            int first = heap.peek();
            for(int i = first;i < first + groupSize;i++){
                if(!hashMap.containsKey(i)) return false;
                hashMap.put(i, hashMap.get(i) - 1);
                if(hashMap.get(i) == 0){
                    if(heap.peek() != i)
                        return false; // missed numin the middle
                    heap.poll();
                }
            }
        }
        return true;
    }
}
