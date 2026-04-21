class Solution {
    public static int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int water = 0;
        int lMax = height[l];
        int rMax = height[r];
        while(l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(height[l] ,lMax);
                water += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(height[r], rMax);
                water += rMax - height[r];
            }
        }
        return water;
    }
}
