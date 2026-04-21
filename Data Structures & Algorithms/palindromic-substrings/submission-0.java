class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int c = 0;
        for(int i = s.length() - 1;i >= 0;i--){
            for(int j = i;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2 || dp[i + 1][j - 1]){
                        c++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return c;
    }
}
