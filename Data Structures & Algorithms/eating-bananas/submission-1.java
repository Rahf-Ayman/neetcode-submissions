class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
//        Arrays.sort(piles);
        int max = 0;
        for(int i = 0;i < piles.length;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int l = 0;
        int r = max;
        int res = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int sum = 0;
            for(int i = 0;i < piles.length;i++){
                sum +=  Math.ceil((double) piles[i] / mid);
            }
            if(sum <= h){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
}
