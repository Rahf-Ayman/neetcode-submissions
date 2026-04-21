class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        Integer [][] memo = new Integer[nums.length + 1][sum * 2 + 1];
        return dfsTarget(nums,target,0,0,memo,sum);
    }

    public int dfsTarget(int [] nums, int target ,int i ,int sum,Integer [][] memo ,int arrSum){
        if(sum == target && i >= nums.length) return 1;
        if(i >= nums.length) return 0;

        if(memo[i][sum + arrSum] != null){
            return memo[i][sum + arrSum];
        }
        int res = dfsTarget(nums,target,i + 1,sum + nums[i],memo,arrSum);
        res += dfsTarget(nums,target,i + 1,sum - nums[i],memo,arrSum);

        memo[i][sum + arrSum] = res;

        return memo[i][sum + arrSum];
    }
}
