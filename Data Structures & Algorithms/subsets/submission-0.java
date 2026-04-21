class Solution {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        go(new ArrayList<>(),list,nums,0);
        return list;
    }

    public static void go(List<Integer> subList ,List<List<Integer>> list ,int[] nums ,int j){
        list.add(new ArrayList<>(subList));
        Set<Integer> set = new HashSet<>();
        for(int i = j;i < nums.length;i++){
            if(!set.contains(nums[i])){
                subList.add(nums[i]);
                set.add(nums[i]);
                go(subList , list ,nums , i + 1);
                subList.removeLast(); 
            }
        }
    }
}
