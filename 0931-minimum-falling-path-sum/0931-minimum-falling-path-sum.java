class Solution {
    // public int minFallingPathSum(int[][] matrix) {
    //     int ans = Integer.MAX_VALUE;
    //     for(int i = 0; i < matrix[0].length; i++){
    //         ans = Math.min(ans,minpath(0, i, matrix));
    //     }
    //     return  ans;
    // }
    // int minpath(int i, int j, int[][]matrix){
    //     if(j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
    //     if(i == matrix.length - 1) return matrix[i][j];
    //     int btm = minpath(i+1, j, matrix);
    //     int btmlft = minpath(i+1, j-1, matrix);
    //     int btmrgt = minpath(i+1, j+1, matrix);
    //     return matrix[i][j] + Math.min(btmlft, Math.min(btm, btmrgt));
    // }


    // public int minFallingPathSum(int[][] matrix) {
    //     int[][] matrix = new int[matrix.length][matrix[0].length];
    //     for(int[] row : matrix){
    //         Arrays.fill(row, 1000);
    //     }
    //     int ans = Integer.MAX_VALUE;
    //     for(int i = 0; i < matrix[0].length; i++){
    //         ans = Math.min(ans,minpath(0, i, matrix, matrix));
    //     }
    //     return  ans;
    // }
    // int minpath(int i, int j, int[][]matrix, int[][] matrix){
    //     if(j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
    //     if(i == matrix.length - 1) return matrix[i][j];
    //     if(matrix[i][j] != 1000) return matrix[i][j];
    //     int btm = minpath(i+1, j, matrix, matrix);
    //     int btmlft = minpath(i+1, j-1, matrix, matrix);
    //     int btmrgt = minpath(i+1, j+1, matrix, matrix);
    //     matrix[i][j] = matrix[i][j] + Math.min(btmlft, Math.min(btm, btmrgt));
    //     return matrix[i][j];
    // }


    public int minFallingPathSum(int[][] matrix) {
        minpath(matrix);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            ans = Math.min(ans, matrix[0][i]);
        }
        return ans;
    }
    void minpath(int[][]matrix){
        int n = matrix.length;
        for(int i = n-2; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int btm = matrix[i+1][j];
                int btmleft = Integer.MAX_VALUE;
                int btmright = Integer.MAX_VALUE;
                if(j-1 >= 0) btmleft = matrix[i+1][j-1];
                if(j+1 < n) btmright = matrix[i+1][j+1];
                matrix[i][j] = matrix[i][j] + Math.min(btmleft, Math.min(btm, btmright));
            }
        }
    }
}