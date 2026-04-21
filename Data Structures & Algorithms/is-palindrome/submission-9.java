class Solution {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l < r){
            while(r > 0 && !(s.charAt(r) >= 'a' && s.charAt(r) <= 'z') && !(s.charAt(r) >= '0' && s.charAt(r) <= '9') ){
                r--;
            }
            if(l == r) return true;
            while(l < s.length() - 1 && !(s.charAt(l) >= 'a' && s.charAt(l) <= 'z') && !(s.charAt(l) >= '0' && s.charAt(l) <= '9')){
                l++;
            }
            if(l == r) return true;
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
