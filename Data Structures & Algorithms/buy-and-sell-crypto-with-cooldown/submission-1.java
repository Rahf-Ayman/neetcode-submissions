class Solution {
    public int maxProfit(int[] prices) {
        Integer [][] memo = new Integer[prices.length][2];

        return dfsProfit(prices,0,1,memo);
    }

    public int dfsProfit(int [] prices, int i ,int canBuy, Integer memo [] []){
        if(i >= prices.length) return 0;
        int buy = 0 ,sell = 0;
        if(memo[i][canBuy] != null) return memo[i][canBuy];
        int cooldown = dfsProfit(prices,i + 1, canBuy,memo);
        
        if(canBuy == 1){
            buy = dfsProfit(prices,i + 1,0 ,memo) - prices[i];
            memo[i][canBuy] = Math.max(buy,cooldown);
        }else{
            sell = dfsProfit(prices,i + 2,1,memo) + prices[i];
            memo[i][canBuy] = Math.max(sell,cooldown);
        }

        return memo[i][canBuy];
    }
}
