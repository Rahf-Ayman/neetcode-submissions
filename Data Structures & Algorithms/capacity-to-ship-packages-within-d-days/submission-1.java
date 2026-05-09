class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int l = 0;
        
        for(int i : weights){
            l = Math.max(l , i);
            sum += i;
        }
        int r = sum;
        while(l < r){
            int mid  = l + (r - l) / 2;
            int dW = mid;
            int lastDays = 1;
            int currLoad = 0;
            for(int i = 0;i < weights.length;i++){
                if(currLoad + weights[i] > dW){
                    lastDays++;
                    currLoad = weights[i];
                }else{
                    currLoad += weights[i];
                }

            }

            if(lastDays <= days){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}