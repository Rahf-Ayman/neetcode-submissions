class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
//        go(new ArrayList<>(),list,nums,0 ,target, 0);
        backtrack(new ArrayList<>(),list,nums,0,target);
        return list;
    }
    public static void backtrack(List<Integer> subList ,List<List<Integer>> list ,int[] nums ,int j ,int target){
        if(target == 0){
            list.add(new ArrayList<>(subList));
            return;
        }
        if(target < 0 || j >= nums.length){
            return;
        }
        subList.add(nums[j]);
        backtrack(subList,list,nums,j,target - nums[j]);
        subList.remove(subList.size() - 1);
        backtrack(subList,list,nums,j + 1,target);
    }
}
