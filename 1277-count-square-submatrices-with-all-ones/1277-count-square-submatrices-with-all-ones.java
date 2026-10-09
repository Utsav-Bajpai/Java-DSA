class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0];
        }
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i];
        }
        return squares(matrix, dp);
    }
    int squares(int[][]matrix, int[][] dp){
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                int num0 = dp[i-1][j-1];
                int num1 = dp[i-1][j];
                int num2 = dp[i][j-1];
                if(matrix[i][j] != 0){
                    dp[i][j] = matrix[i][j] + Math.min(num0, Math.min(num1, num2));
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
}