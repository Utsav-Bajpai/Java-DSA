class Solution {
    public int minDistance(String word1, String word2) {
        int com = lps(word1, word2);
        int tlen = word1.length() + word2.length();
        return tlen - 2 * com;
    }
    int lps(String s, String rev){
        int dp[][] = new int[s.length() + 1][rev.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= rev.length(); j++){
                if(s.charAt(i - 1) == rev.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][rev.length()];
    }
}