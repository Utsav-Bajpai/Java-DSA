class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
    //     for(int[] i : dp){
    //         Arrays.fill(i, Integer.MAX_VALUE);
    //     }
    //     return findpath(0, 0, triangle, dp);
    // }
    // int findpath(int i, int j, List<List<Integer>> triangle, int[][] dp){
    //     if(i == triangle.size() - 1) return triangle.get(i).get(j);
    //     if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
    //     int btm = findpath(i + 1, j, triangle, dp);
    //     int btmright = findpath(i+1, j + 1, triangle, dp);
    //     dp[i][j] = triangle.get(i).get(j) + Math.min(btm, btmright);
    //     return dp[i][j];
    // }

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
    //     for(int i = 0; i < dp[0].length; i++){
    //         dp[dp.length - 1][i] = triangle.get(triangle.size() - 1).get(i);
    //     }
    //     return findpath(triangle, dp);
    // }
    // int findpath(List<List<Integer>> triangle, int[][] dp){
    //     for(int i = dp.length - 2; i >= 0; i--){
    //         for(int j = i; j >= 0; j--){
    //             int down = dp[i+1][j];
    //             int downright = dp[i+1][j+1];
    //             dp[i][j] = triangle.get(i).get(j) + Math.min(down, downright);
    //         }
    //     }
    //     return dp[0][0];
    // }


    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i = 0; i < dp.length; i++){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        return findpath(triangle, dp);
    }
    int findpath(List<List<Integer>> triangle, int[] dp){
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}