class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] a = nums1;
        int [] b = nums2;

        int total = a.length + b.length;
        int half = (total + 1) / 2; // solution in left partition
        if(a.length > b.length){
            int [] temp = a;
            a = b;
            b = temp;
        }
        int l = 0;
        int r = a.length;

        while(l <= r){
            int mid = (r + l) / 2;
            int i = half - mid;

            int aLeft = mid > 0 ? a[mid - 1] : Integer.MIN_VALUE;
            int aright = mid < a.length ? a[mid] : Integer.MAX_VALUE;
            int bLeft = i > 0 ? b[i - 1] : Integer.MIN_VALUE;
            int bright = i < b.length ? b[i] : Integer.MAX_VALUE;

            if(aLeft <= bright && bLeft <= aright){
                if(total % 2 != 0){
                    return Math.max(aLeft,bLeft);
                }else{
                    return (Math.max(aLeft,bLeft) + Math.min(aright ,bright)) / 2.0;
                }
            }else if (aLeft > bright){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1.0;
    }
}
