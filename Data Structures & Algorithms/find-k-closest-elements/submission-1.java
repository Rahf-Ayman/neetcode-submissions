class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        for(r = 0;r < arr.length;r++){
            if(r - l + 1 > k){
                int top = Math.abs(x - arr[r]);
                int bot = Math.abs(x - arr[l]);
                if(top < bot || (top == bot && arr[r] == arr[l])){
                    l++;
                }else{
                    break;
                }
            }
        }
        for(int i = l;i < r ;i++){
            list.add(arr[i]);
        }
        return list;
    }
}