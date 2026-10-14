class Solution {
    public int maxProfit(int[] prices) {

        int hasStock = -prices[0];
        int cannotBuy = Integer.MIN_VALUE;
        int canBuy = 0;

        for (int i = 1; i < prices.length; i++) {
            int newHasStock = Math.max(hasStock, canBuy - prices[i]);
            int newCannotBuy = hasStock + prices[i];
            int newCanBuy = Math.max(canBuy, cannotBuy);
            hasStock = newHasStock;
            cannotBuy = newCannotBuy;
            canBuy = newCanBuy;
        }
        return Math.max(cannotBuy, canBuy);
    }
}