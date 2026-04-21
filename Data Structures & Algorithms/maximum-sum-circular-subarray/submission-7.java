class Solution {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSuffix [] = new int [nums.length + 1];

        maxSuffix[nums.length - 1] = nums[nums.length - 1];
        int suffix = nums[n - 1];
        for(int i = n - 2;i >= 0;i--){
            suffix = suffix + nums[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffix);
        }
        
        int maxRes = nums[0];
        int max = 0;
        int prefix = 0;
        
        int circularSum = nums[0];
        for(int i = 0;i < n;i++){
            max = Math.max(max + nums[i],nums[i]);
            maxRes = Math.max(max,maxRes);
            
            prefix += nums[i];
            circularSum = Math.max(circularSum, prefix + maxSuffix[i + 1]);
        }
        return Math.max(maxRes,circularSum);
    }
}