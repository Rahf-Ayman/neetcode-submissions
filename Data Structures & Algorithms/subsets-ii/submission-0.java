class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        go(new ArrayList<>(),list,0,nums);
        return list;
    }
    public static void go(List<Integer> sublist, List<List<Integer>> list,int j,int []nums){
        list.add(new ArrayList<>(sublist));
        Set<Integer> set = new HashSet<>();
        for(int i = j;i < nums.length;i++){
            if(!set.contains(nums[i])){
                sublist.add(nums[i]);
                set.add(nums[i]);
                go(sublist,list,i + 1,nums);
                sublist.remove(sublist.size() - 1);
            }
            
        }
    }
}
