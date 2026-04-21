class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String , Integer> memo = new HashMap<>();
        return dfsProfit(prices,0,true,memo);
    }

    public int dfsProfit(int [] prices, int i ,boolean canBuy, HashMap<String , Integer> memo){
        if(i >= prices.length) return 0;
        
        String key = i + "_" + canBuy;
        if(memo.containsKey(key)) return memo.get(key);
        int coolDown = dfsProfit(prices,i + 1,canBuy,memo);
        if(canBuy){
            int buy = dfsProfit(prices,i + 1,false,memo) - prices[i];
            memo.put(key, Math.max(buy,coolDown));
        }else{
            int sell = dfsProfit(prices,i + 2,true,memo) + prices[i];
            memo.put(key, Math.max(sell,coolDown));
        }
        
        return memo.get(key);
    }
}
