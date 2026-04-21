class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        go(new ArrayList<>(),list,nums,0 ,target, 0);
        return list;
    }
    public static void go(List<Integer> subList ,List<List<Integer>> list ,int[] nums ,int j ,int target ,int sum){
        if(sum == target)
        list.add(new ArrayList<>(subList));
        for(int i = j;i < nums.length;i++){
           if(sum + nums[i] <= target){
               subList.add(nums[i]);
               go(subList , list ,nums , i ,target, sum + nums[i]);
               subList.remove(subList.size() - 1);
           }
        }
    }
}
