// class Solution {
    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length][2];
    //     for(int[] i : dp){
    //         Arrays.fill(i, Integer.MIN_VALUE);
    //     }
    //     return profit(prices, 0, 1, dp);
    // }
    // int profit(int[] prices, int idx, int buy, int[][] dp){
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy] != Integer.MIN_VALUE) return dp[idx][buy];
    //     if(buy == 1){
    //         // int profit1 += -prices[idx] + profit(prices, idx+1, 0);
    //         // int profit2 += profit(prices, idx+1, 1);
    //         dp[idx][buy] = Math.max((-prices[idx] + profit(prices, idx+1, 0, dp)), profit(prices, idx+1, 1, dp));
    //         return dp[idx][buy];
    //     }else{
    //         dp[idx][buy] = Math.max((prices[idx] + profit(prices, idx+1, 1, dp)), profit(prices, idx+1, 0, dp));
    //         return dp[idx][buy];
    //     }
    // }


    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length + 1][2];
    //     return profit(prices, dp);
    // }
    // int profit(int[] prices, int[][] dp){
    //     dp[prices.length][0] = dp[prices.length][1] = 0;
    //     for(int i = prices.length - 1; i >= 0; i--){
    //         for(int buy = 0; buy <= 1; buy++){
    //             if(buy == 1){
    //                 dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
    //             }else{
    //                 dp[i][buy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
    //             }
    //         }
    //     }
    //     return dp[0][1];
    // }


    
class Solution {
    public int maxProfit(int[] prices) {
        int[] ahead = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            int[] curr = new int[2];

            curr[1] = Math.max(
                -prices[i] + ahead[0],
                ahead[1]
            );

            curr[0] = Math.max(
                prices[i] + ahead[1],
                ahead[0]
            );

            ahead = curr;
        }

        return ahead[1];
    }
}