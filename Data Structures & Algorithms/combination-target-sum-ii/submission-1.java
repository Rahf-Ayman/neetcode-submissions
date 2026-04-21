class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        go(new ArrayList<>(),list,candidates,0 ,target, 0);
        // backtrack(new ArrayList<>(),list,candidates,0,target);
        return list;
    }
    public static void go(List<Integer> subList ,List<List<Integer>> list ,int[] nums ,int j ,int target ,int sum){
        if(sum == target)
            list.add(new ArrayList<>(subList));
        Set<Integer> set = new HashSet<>();
        for(int i = j;i < nums.length;i++){
            if(sum + nums[i] <= target && !set.contains(nums[i])){
                subList.add(nums[i]);
                set.add(nums[i]);
                go(subList , list ,nums , i + 1 ,target, sum + nums[i]);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
