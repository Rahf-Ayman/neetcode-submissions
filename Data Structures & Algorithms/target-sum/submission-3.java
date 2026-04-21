class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int n : nums) sum += n;

    // impossible case
    if (target > sum || target < -sum) return 0;

    int offset = sum;
    int n = nums.length;

    int[][] dp = new int[n + 1][2 * sum + 1];

    // base case: at end, sum = target
    dp[n][target + offset] = 1;

    for (int i = n - 1; i >= 0; i--) {
        for (int currSum = -sum; currSum <= sum; currSum++) {

            int shifted = currSum + offset;

            int add = 0, sub = 0;

            // check bounds before accessing
            if (currSum + nums[i] <= sum)
                add = dp[i + 1][currSum + nums[i] + offset];

            if (currSum - nums[i] >= -sum)
                sub = dp[i + 1][currSum - nums[i] + offset];

            dp[i][shifted] = add + sub;
        }
    }

    // start from sum = 0
    return dp[0][offset];
}
}
