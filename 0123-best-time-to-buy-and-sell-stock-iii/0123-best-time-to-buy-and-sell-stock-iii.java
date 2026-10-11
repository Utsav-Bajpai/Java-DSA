class Solution {
    // public int maxProfit(int[] prices) {
    //     int[][] dp = new int[prices.length][2];
    //     for(int[] i : dp){
    //         Arrays.fill(i, Integer.MIN_VALUE);
    //     }
    //     return profit(prices, 0, 1, dp, 2);
    // }
    // int profit(int[] prices, int idx, int buy, int[][] dp, int cap){
    //     if(cap == 0) return 0;
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy] != Integer.MIN_VALUE) return dp[idx][buy];
    //     if(buy == 1){
    //         // int profit1 += -prices[idx] + profit(prices, idx+1, 0);
    //         // int profit2 += profit(prices, idx+1, 1);
    //         dp[idx][buy] = Math.max((-prices[idx] + profit(prices, idx+1, 0, dp, cap)), profit(prices, idx+1, 1, dp, cap));
    //         return dp[idx][buy];
    //     }else{
    //         dp[idx][buy] = Math.max((prices[idx] + profit(prices, idx+1, 1, dp, cap-1)), profit(prices, idx+1, 0, dp, cap));
    //         return dp[idx][buy];
    //     }
    // }


    // public int maxProfit(int[] prices) {
    //     int[][][] dp = new int[prices.length + 1][2][3];
    //     return profit(prices, dp);
    // }
    // int profit(int[] prices, int[][][] dp){
    //     for(int i = prices.length - 1; i >= 0; i--){
    //         for(int j = 0; j <= 1; j++){
    //             for(int k = 1; k <= 2; k++){
    //                 if(j == 1){
    //                     dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
    //                 }else{
    //                     dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
    //                 }
    //             }
    //         }
    //     }
    //     return dp[0][1][2];
    // }


    // public int maxProfit(int[] prices) {
    //     int[][] after = new int[2][3];
    //     int[][] curr = new int[2][3];
    //     for(int i = prices.length - 1; i >= 0; i--){
    //         for(int j = 0; j <= 1; j++){
    //             for(int k = 1; k <= 2; k++){
    //                 if(j == 1){
    //                     curr[j][k] = Math.max(-prices[i] + after[0][k], after[1][k]);
    //                 }else{
    //                     curr[j][k] = Math.max(prices[i] + after[1][k - 1], after[0][k]);
    //                 }
    //             }
    //         }
    //         after = curr;
    //     }
    //     return curr[1][2];
    // }


    public int maxProfit(int[] prices) {
        int buy1, profit1, buy2, profit2;
        buy1 = buy2 = Integer.MAX_VALUE;
        profit1 = profit2 = 0;
        for(int i : prices){
            buy1 = Math.min(buy1, i);
            profit1 = Math.max(profit1, i - buy1);
            buy2 = Math.min(buy2, i - profit1);
            profit2 = Math.max(profit2, i - buy2);
        }
        return profit2;
    }
}