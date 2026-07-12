class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        pattern(ans, "", 0, 0, n);
        return ans;
    }
    void pattern(List<String> ans, String curr, int open, int close, int n){
        if(curr.length() == 2 * n){
            ans.add(curr);
            return;
        }
        if(open < n){
            pattern(ans,curr + "(", open + 1, close, n);
        }
        if(close < open){
            pattern(ans,curr + ")", open, close + 1, n);
        }
    }
}