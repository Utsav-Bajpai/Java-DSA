class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(comp(words[i], words[j]) && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    boolean comp(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int i = 0, j = 0;
        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return (i == s1.length() && j == s2.length());
    }
}