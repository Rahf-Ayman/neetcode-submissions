class Solution {
    public int uniquePaths(int m, int n) {
        Integer [][] memo = new Integer [m + 1][n + 1];
        return dfsUnique(m,n,0,0,memo);
    }

    public int dfsUnique(int m ,int n,int i,int j ,Integer [][] memo){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        if (memo[i][j] != null) return memo[i][j];
        
        int down = dfsUnique(m,n,i + 1 ,j,memo);
        int right = dfsUnique(m,n,i ,j + 1,memo);
        memo[i][j] = down + right;
        return memo[i][j];
    }
}
