class Solution {
    public String longestPalindrome(String s) {
        boolean [][]dp = new boolean[s.length()][s.length()];
        int resLen = 0;
        int res = 0;

        for(int i = s.length() - 1;i >= 0;i--){
            for(int j = i;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(j - i + 1 > resLen){
                            resLen = j - i + 1;
                            res = i;
                        }
                    }
                }
            }
        }
        return s.substring(res ,res + resLen);
    }
}
