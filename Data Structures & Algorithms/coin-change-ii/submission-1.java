class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        Integer [][] memo = new Integer[coins.length + 1][amount + 1];
        return dfsChange(coins,0,amount,memo);
    }

    public int dfsChange(int [] coins, int i, int amount,Integer [][] memo){
        if(amount == 0) return 1;
        if(i >= coins.length) return 0;
        
        if(memo[i][amount] != null) return memo[i][amount];
        
        int res = 0;
        if(amount >= coins[i]){
            res = dfsChange(coins,i ,amount - coins[i],memo);
            res += dfsChange(coins,i + 1,amount,memo);
        }

        memo[i][amount] = res;
        return memo[i][amount];
    }
}
