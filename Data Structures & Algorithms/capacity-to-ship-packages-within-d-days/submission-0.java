class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int l = 0;
        int r = 0;
        for(int i : weights){
            l = Math.max(i ,l);
            sum += i;
        }
        r = sum;
        int res = sum;
        while(l <= r){
            int mid  = l + (r - l) / 2;
            if(canWeight(weights,days,mid)){
                res = Math.min(res , mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return res;
    }
    public static boolean canWeight(int [] w, int d , int cap){
        int lastDays = 1;
        int curr = cap;
        for(int i = 0;i < w.length;i++){
            if(curr - w[i] < 0){
                lastDays++;
                if(lastDays > d){
                    return false;
                }
                curr = cap;
            }

            curr -= w[i];
        }
        return true;
    }
}