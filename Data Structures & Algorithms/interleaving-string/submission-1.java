class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean [][][] memo = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return dfsInterleave(s1,s2,s3,0,0,0,memo);
    }
    public boolean dfsInterleave(String s1,String s2 ,String s3,int i,int j,int k ,Boolean memo[][][]){
        if(k >= s3.length()) return true;
        if(i < s1.length() && j < s2.length() && s3.charAt(k) != s2.charAt(j) && s3.charAt(k) != s1.charAt(i))
            return false;

        if(memo[i][j][k] != null) return memo[i][j][k];

        boolean first = false , second = false;
        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            first = dfsInterleave(s1,s2,s3,i + 1,j,k + 1,memo);
        }
        if(j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            second = dfsInterleave(s1,s2,s3,i,j + 1,k + 1,memo);
        }
        memo[i][j][k] = first || second;

        return  memo[i][j][k];
    }
}
