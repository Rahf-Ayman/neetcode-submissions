class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int [] pre = new int[nums.length];
        for(int i = 1;i < nums.length;i++){
            pre[i] = pre[i - 1] + nums[i];
        }
        int l = 0;
        int currSum = 0;
        int minlen = nums.length + 1;
        for(int r = 0;r < nums.length;r++){
            currSum += nums[r];
            while(currSum - nums[l] >= target){
                minlen = Math.min(minlen, r - l + 1);
                currSum -= nums[l];
                l++;
            }
            if(currSum >= target){
                minlen = Math.min(minlen, r - l + 1);
            }
        }
        return minlen == (nums.length + 1) ? 0 : minlen;
    }
}