class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = funct(coins.length - 1, amount, coins, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int funct(int idx, int amount, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return Integer.MAX_VALUE;
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int nottake = funct(idx - 1, amount, coins, dp);

        int take = Integer.MAX_VALUE;

        if (coins[idx] <= amount) {
            int res = funct(idx, amount - coins[idx], coins, dp);

            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        return dp[idx][amount] = Math.min(take, nottake);
    }
}
