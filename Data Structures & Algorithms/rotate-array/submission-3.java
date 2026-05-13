class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int curr = 0;
        int prev;
        int n = nums.length;
        for(int i = 0; count < nums.length;i++){ // every i indicate a start of cycle
            curr = i;
            prev = nums[i];
            
            do{
              int nextidx = (curr + k) % n;
              int temp = nums[nextidx];
              nums[nextidx] = prev;
              prev = temp; // carry
              curr = nextidx;
              count++;  
            }while(i != curr);
        }
    }
    
}