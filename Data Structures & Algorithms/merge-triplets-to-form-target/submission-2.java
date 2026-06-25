class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false ,y = false, z = false;
        for(int i []: triplets){
            x |= (i[0] == target[0] && i[1] <= target[1] && i[2] <= target[2]);
            y |= (i[0] <= target[0] && i[1] == target[1] && i[2] <= target[2]);
            z |= (i[0] <= target[0] && i[1] <= target[1] && i[2] == target[2]);
            if(x && y && z){
                return true;
            }
        }
        return false;
    }
}
