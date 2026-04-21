class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] arr = new int [2];
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            if((numbers[l] + numbers[r]) < target){
                l++;
            }else if((numbers[l] + numbers[r]) > target){
                r--;
            }else{
                break;
            }
        }
        arr[0] = l + 1;
        arr[1] = r + 1;
        return arr;
    }
}
