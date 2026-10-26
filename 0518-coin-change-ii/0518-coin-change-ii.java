class Solution {
    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length][amount + 1];
    //     for(int[] i : dp){
    //         Arrays.fill(i, -1);
    //     }
    //     return ways(coins.length - 1, amount, coins, dp);
    // }
    // int ways(int idx, int amount, int[] coins, int[][] dp){
    //     if(idx < 0) return 0;
    //     if(amount == 0) return 1;
    //     if(dp[idx][amount] != -1) return dp[idx][amount];
    //     int nottake = ways(idx - 1, amount, coins,dp);
    //     int take = 0;
    //     if(coins[idx] <= amount){
    //         take = ways(idx, amount - coins[idx], coins, dp);
    //     }
    //     dp[idx][amount] = take + nottake;
    //     return dp[idx][amount];
    // }


    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length][amount + 1];
    //     for(int i = 0; i < coins.length; i++){
    //         dp[i][0] = 1;
    //     }
    //     for(int i = 0; i <= amount; i++){
    //         if(i % coins[0] == 0) dp[0][i] = 1;
    //     }
    //     for(int i = 1; i < coins.length; i++){
    //         for(int j = 0; j <= amount; j++){
    //             int nottake = dp[i - 1][j];
    //             int take = 0;
    //             if(coins[i] <= j){
    //                 take = dp[i][j - coins[i]];
    //             }
    //             dp[i][j] = take + nottake;
    //         }
    //     }
    //     return dp[coins.length - 1][amount];
    // }


    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}