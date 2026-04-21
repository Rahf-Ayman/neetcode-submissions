class Solution {
    public static int trap(int[] height) {
        int water = 0;
        int [] prefix = new int [height.length];
        int [] suffix = new int [height.length];
        int max = height[0];
        for(int i = 0;i < height.length;i++){
            if(height[i] > max){
                max = height[i];
            }
            prefix[i] = max;
        }
        max = height[height.length - 1];
        for(int i = height.length - 1;i >=0 ;i--){
            if(height[i] > max){
                max = height[i];
            }
            suffix[i] = max;
        }
        for(int i = 0;i < height.length;i++){
            water += Math.min(prefix[i] ,suffix[i]) - height[i];
        }
        return water;
    }
}
