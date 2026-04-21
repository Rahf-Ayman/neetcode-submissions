class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int offset = 0;
        for(int i : nums){
            offset += i;
        }
        if (target > offset || target < -offset) return 0;
        int [][] dp = new int[nums.length + 1][offset * 2 + 1];
        dp[nums.length][target + offset] = 1;
        for(int i = nums.length - 1;i >= 0;i--){
            for(int currSum = -offset; currSum <= offset;currSum++){
                if(currSum + nums[i] <= offset)
                    dp[i][currSum + offset] += dp[i + 1][currSum + nums[i] + offset];
                if(currSum - nums[i] >= -offset)
                    dp[i][currSum + offset] += dp[i + 1][currSum - nums[i] + offset];
            }
        }

        return dp[0][offset];
    }
}
