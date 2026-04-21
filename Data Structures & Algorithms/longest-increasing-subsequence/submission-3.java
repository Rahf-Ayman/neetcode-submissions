class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer [][] arr = new Integer [nums.length][nums.length + 1];
        return dfsLIS(nums,0 , -1,arr);
    }
    public int dfsLIS(int []nums,int i ,int j,Integer [][] arr){
        if(i == nums.length) return 0;
        int include = 0, exclude = 0;
        if(arr[i][j + 1] != null) return arr[i][j + 1];
        if(j == -1 || nums[i] > nums[j]){
            include = dfsLIS(nums,i + 1,i,arr) + 1;
        }
            exclude = dfsLIS(nums,i + 1,j,arr);
        arr[i][j + 1] = Math.max(include,exclude);
        return arr[i][j + 1];
    }
}
