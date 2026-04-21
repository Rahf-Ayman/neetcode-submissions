class Solution {
    public int numDecodings(String s) {
        int dp[] = new int [s.length()];
        Arrays.fill(dp , -1);
        return DFSEx(s,0,dp);
    }

    public static int DFSEx(String s ,int i,int dp[]){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int one = DFSEx(s,i + 1,dp);
        
        int two = 0;
        if(i + 1 < s.length()){
            int num = Integer.parseInt(s.substring(i ,i + 2));
            if(num <= 26)
                two = DFSEx(s,i + 2,dp);
        }
        
        return dp[i] = one + two;
    }
}
