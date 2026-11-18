// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int size = s.length();
//         Boolean dp[][] = new Boolean[size+1][size+1];
//         return ispossible(0, 1, s, wordDict, dp);
//     }
//     boolean ispossible(int start, int end, String s, List<String> wordDict, Boolean[][] dp){
//         if(start >= s.length()) return true;
//         if(end > s.length()) return false;
//         if(dp[start][end] != null) return dp[start][end];
//         if(wordDict.contains(s.substring(start, end))){
//             boolean take = ispossible(end, end+1, s, wordDict, dp);
//             if(take) return dp[start][end] = take;
//         }
//         boolean nottake = ispossible(start, end+1, s, wordDict, dp);
//         return dp[start][end] = nottake;
//     }
// }
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        Boolean dp[] = new Boolean[size+1];
        return ispossible(0, s, wordDict, dp);
    }
    boolean ispossible(int start, String s, List<String> wordDict, Boolean[] dp){
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        for(int i = start + 1; i <= s.length();i++){
            if(wordDict.contains(s.substring(start, i))){
                if(ispossible(i, s, wordDict, dp)){
                    return dp[i] = true;
                }
            }
        }
        return dp[start] = false;
    }
}