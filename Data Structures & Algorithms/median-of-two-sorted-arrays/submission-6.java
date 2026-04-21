class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] a = nums1;
        int [] b = nums2;

        int total = a.length + b.length;
        int half =(int) Math.ceil(total / 2.0); // solution in left partition
        if(a.length > b.length){
            int [] temp = a;
            a = b;
            b = temp;
        }
        int l = 0; // min number of elements can choose
        int r = a.length; // max number of elements can choose

        while(l <= r){
            int mid = l + (r - l) / 2;
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
        return 0;
    }
}
