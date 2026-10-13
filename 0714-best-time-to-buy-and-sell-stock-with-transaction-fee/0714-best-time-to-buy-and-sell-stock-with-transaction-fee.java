class Solution {
    // public int maxProfit(int[] prices, int fee) {
    //     return findprofit(0, 1, prices, fee);
    // }
    // int findprofit(int idx, int buy, int[] prices, int fee){
    //     if(idx == prices.length) return 0;
    //     int profit = 0;
    //     if(buy == 1){
    //         profit = Math.max(-prices[idx] + findprofit(idx+1, 0, prices, fee), findprofit(idx+1, 1, prices, fee));
    //     }else{
    //         profit = Math.max(prices[idx] -fee + findprofit(idx+1, 1, prices, fee), findprofit(idx+1, 0, prices, fee));
    //     }
    //     return profit;
    // }


    public int maxProfit(int[] prices, int fee) {
        int[] after = new int[2];
        int[] curr = new int[2];
        for(int i = prices.length-1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    curr[buy] = Math.max(-prices[i] + after[0], after[1]);
                }else{
                    curr[buy] = Math.max(prices[i] - fee + after[1], after[0]);
                }
            }
            int[] temp = after;
            after = curr;
            curr = temp;
        }
        return after[1];
    }
}