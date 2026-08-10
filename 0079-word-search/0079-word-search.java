class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = dfs(board, i, j, 0, word);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, int i, int j, int idx, String word){
        if(idx > word.length()-1) return true;
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length -1 ) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean up = dfs(board, i+1, j, idx + 1, word);
        boolean down = dfs(board, i-1, j, idx + 1, word);
        boolean left = dfs(board, i, j+1, idx + 1, word);
        boolean right = dfs(board, i, j-1, idx + 1, word);
        board[i][j] = temp;
        return (up || down || left || right);
    }
}