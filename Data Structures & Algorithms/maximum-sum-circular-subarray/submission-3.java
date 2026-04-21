class Solution {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int minSum = 0;
        int maxSum = 0;
        int minRes = nums[0];
        int maxRes = nums[0];
        
        for(int i = 0;i < nums.length;i++){
            minSum = Math.min(nums[i], minSum + nums[i]);
            minRes = Math.min(minRes, minSum);

            maxSum = Math.max(nums[i], maxSum + nums[i]);
            maxRes = Math.max(maxRes, maxSum);
            
            totalSum += nums[i];
        }
        
        int circularSum = totalSum - minRes;
        
        if(minRes == totalSum){ // if all element is negative to not return 0 from circularSum
            return maxRes;
        }
        
        return Math.max(maxRes,circularSum);
    }
}