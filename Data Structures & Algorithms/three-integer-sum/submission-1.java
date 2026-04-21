class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Set<List<Integer>> exist = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum > 0){
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    List<Integer> sublist = new LinkedList<>();
                    sublist.add(nums[i]);
                    sublist.add(nums[l]);
                    sublist.add(nums[r]);
                    if(!exist.contains(sublist)){
                       list.add(sublist);
                       exist.add(sublist); 
                    }
                    l++;
                    r--;
                }
            }
        }
        return list;
    }
}
