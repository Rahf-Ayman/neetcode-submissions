class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer [][] memo = new Integer[text1.length() + 1][text2.length() + 1];

        return dfsLCS(text1, text2,text1.length(),text2.length(),memo);
    }
    public int dfsLCS(String text1, String text2, int i ,int j ,Integer[][]memo){
        if(i == 0 || j == 0){
            return 0;
        }
        if(memo[i][j] != null) return memo[i][j];

        if(text1.charAt(i - 1) == text2.charAt(j - 1)){
            memo[i][j] = 1 + dfsLCS(text1,text2,i - 1,j - 1 ,memo);
            return memo[i][j];
        }
        memo[i][j] = Math.max(dfsLCS(text1,text2,i,j - 1 ,memo),dfsLCS(text1,text2,i - 1,j  ,memo));
        return memo[i][j];
    }
}
