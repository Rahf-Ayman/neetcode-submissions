class Solution {
    public int rob(int[] nums) {
        int []dp = new int [nums.length];
        Arrays.fill(dp,-1);
        
        return go(nums,nums.length,dp);
    }
    
    public static int go(int [] nums,int n,int [] dp){
        if(n <= 0) return 0;
        if(n == 1) return nums[n - 1];
        
        if(dp[n - 1] != -1) return dp[n  - 1];
        
        int pick = nums[n - 1] + go(nums,n - 2, dp);
        int notPick = go(nums,n - 1,dp);
        
        int profit = Math.max(pick,notPick);
        dp[n - 1] = profit;
        return profit;
    }
}
