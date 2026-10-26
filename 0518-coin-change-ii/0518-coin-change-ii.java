class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return ways(coins.length - 1, amount, coins, dp);
    }
    int ways(int idx, int amount, int[] coins, int[][] dp){
        if(idx < 0) return 0;
        if(amount == 0) return 1;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int nottake = ways(idx - 1, amount, coins,dp);
        int take = 0;
        if(coins[idx] <= amount){
            take = ways(idx, amount - coins[idx], coins, dp);
        }
        dp[idx][amount] = take + nottake;
        return dp[idx][amount];
    }
}