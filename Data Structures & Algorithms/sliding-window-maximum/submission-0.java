class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int [] arr = new int [nums.length - k + 1];
        int l = 0;
        int max = 0;
        int lastMax = 0;
        int i = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int r = 0;r < nums.length;r++){
            queue.add(nums[r]);
            while(r - l + 1 >= k){
                arr[i] = queue.peek();
                queue.remove(nums[l]);
                i++;
                l++;
            }
        }
        return arr;
    }
}
