// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] num = new int[n+2];
//         num[0] = 1;
//         num[n+1] = 1;
//         for(int i = 0; i < nums.length; i++){
//             num[i+1] = nums[i];
//         }
//         return find(1, n , num);
//     }
//     int find(int a, int b, int[] num){
//         if(a > b) return 0;
//         int max = Integer.MIN_VALUE;
//         for(int i = a; i <= b; i++){
//             int money = num[a-1] * num[i] * num[b+1] + find(a, i-1, num) + find(i+1, b, num);
//             max = Math.max(max, money);
//         }
//         return max;
//     }
// }
// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] num = new int[n+2];
//         num[0] = 1;
//         num[n+1] = 1;
//         for(int i = 0; i < nums.length; i++){
//             num[i+1] = nums[i];
//         }
//         int[][] dp = new int[num.length][num.length];
//         for(int[] i : dp){
//             Arrays.fill(i, -1);
//         }
//         return find(1, n , num, dp);
//     }
//     int find(int a, int b, int[] num, int[][] dp){
//         if(a > b) return 0;
//         int max = Integer.MIN_VALUE;
//         if(dp[a][b] != -1) return dp[a][b];
//         for(int i = a; i <= b; i++){
//             int money = num[a-1] * num[i] * num[b+1] + find(a, i-1, num, dp) + find(i+1, b, num, dp);
//             max = Math.max(max, money);
//         }
//         return dp[a][b] = max;
//     }
// }
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n+2];
        num[0] = 1;
        num[n+1] = 1;
        for(int i = 0; i < nums.length; i++){
            num[i+1] = nums[i];
        }
        int[][] dp = new int[num.length + 2][num.length + 2];
        for(int a = n; a >= 1; a--){
            for(int b = a; b <= n; b++){
                if(a > b) continue;
                int max = Integer.MIN_VALUE;
                for(int i = a; i <= b; i++){
                    int money = num[a-1] * num[i] * num[b+1] + dp[a][i-1] + dp[i+ 1][b];
                    max = Math.max(max, money);
                }
                dp[a][b] = max;
            }
        }
        return dp[1][n];
    }
}