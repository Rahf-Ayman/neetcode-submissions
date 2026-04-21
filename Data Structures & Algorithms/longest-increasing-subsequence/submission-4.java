class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer [] arr = new Integer[nums.length];
        int maxLIS = 1;
        for(int i = 0;i < nums.length;i++){
            maxLIS = Math.max(maxLIS,dfsLIS(nums,i,arr));
        }
        return maxLIS;
    }
    public int dfsLIS(int []nums,int i ,Integer [] arr){
        if(i == nums.length) return 0;
        if(arr[i] != null) return arr[i];
        int LIS = 1;
        for(int j = i + 1;j < nums.length;j++){
            if(nums[j] > nums[i])
                LIS = Math.max(LIS, dfsLIS(nums,j,arr) + 1);
        }
        arr[i] = LIS;
        return arr[i];
    }
}
