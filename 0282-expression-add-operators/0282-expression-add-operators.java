class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans  = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", ans);
        return ans;
    }
    void dfs(String num, int tar, int idx, long val, long prev, String path, List<String> ans){
        if(idx == num.length()){
            if(val == tar) ans.add(path);
            return;
        }
        for(int i = idx; i < num.length(); i++){
            if (i != idx && num.charAt(idx) == '0') break;
            String currstr = num.substring(idx, i + 1);
            long curr = Long.parseLong(currstr);

            if(idx == 0){
                dfs(num, tar, i + 1, curr, curr, currstr, ans);
            }else{
                dfs(num, tar, i + 1, val + curr, curr, path + "+" + currstr, ans);
                dfs(num, tar, i + 1, val - curr, -curr, path + "-" + currstr, ans);
                dfs(num, tar, i + 1, val - prev + prev * curr, prev * curr, path + "*" + currstr, ans);
            }
        }
    }
}