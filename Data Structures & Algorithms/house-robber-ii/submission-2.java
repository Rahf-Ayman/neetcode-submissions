class Solution {
    public int rob(int[] nums) {
        int []dp = new int [nums.length];
        Arrays.fill(dp,-1);
        int []dp2 = new int [nums.length];
        if(nums.length == 1) return nums[0];
        Arrays.fill(dp2,-1);
        int nums_2[] = new int [nums.length];
        System.arraycopy(nums,0,nums_2,0,nums.length);
        nums_2[nums.length - 1] = 0;
        nums[0] = 0;
        return Math.max(go(nums, nums.length, dp),go(nums_2, nums.length, dp2));
    }

    public int go(int []nums,int i,int []dp){
        if(i <= 0) return 0;
        if(dp[i - 1] != -1) return dp[i - 1];

        int pick = nums[i - 1] + go(nums,i - 2,dp);
        int notPick = go(nums,i - 1,dp);

        dp[i - 1] = Math.max(notPick, pick);
        return dp[i - 1];
    }
}
