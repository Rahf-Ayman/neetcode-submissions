class Solution {
   public int maxProduct(int[] nums) {
        int max =  1;
        int res = nums[0];
        int min = 1;
        for(int i = 0;i < nums.length;i++){
            int temp = max * nums[i];
            max = Math.max(min * nums[i], Math.max(temp, nums[i]));
            min = Math.min(nums[i],Math.min(min * nums[i] , temp));
            res = Math.max(res , max);
        }
        return res;
    }
}
