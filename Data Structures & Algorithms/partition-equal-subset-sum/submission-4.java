class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }
        Boolean [][] memo = new Boolean [nums.length][sum / 2 + 1];
        return dfsCan(nums,sum / 2,0,memo);
    }
    public static boolean dfsCan(int [] nums, int sum ,int i ,Boolean [][] memo){
        if(sum == 0) return true;
        if(i >= nums.length || sum < 0) return false;
        if(memo[i][sum] != null) return memo[i][sum];

        boolean first = dfsCan(nums,sum - nums[i],i + 1,memo);
        boolean second = dfsCan(nums,sum,i + 1,memo);
        memo[i][sum] = first || second;
        return memo[i][sum];
    }
}
