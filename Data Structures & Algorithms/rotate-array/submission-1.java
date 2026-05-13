class Solution {
    public void rotate(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        if(k == nums.length) return;
        if(k > nums.length) k = k % nums.length;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = 0;
        r = k - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        l = k;
        r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}