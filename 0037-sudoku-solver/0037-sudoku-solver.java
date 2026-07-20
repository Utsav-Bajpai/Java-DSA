class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char n = '1'; n <= '9'; n++){
                        if(isvalid(board, i, j, n)){
                            board[i][j] = n;
                            if(solve(board) == true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isvalid(char[][] board, int row, int col, int n){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == n) return false;
            if(board[i][col] == n) return false;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n) return false;
        }
        return true;
    }
}