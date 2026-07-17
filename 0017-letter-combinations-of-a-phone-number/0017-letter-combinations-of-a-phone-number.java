class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuffer op = new StringBuffer();
        int idx = 0;
        lcomb(idx, digits, map, ans, op);
        return ans;
    }
    private void lcomb(int idx, String dig, String[] map, List<String> ans, StringBuffer op){
        if(idx >= dig.length()){
            ans.add(op.toString());
            return;
        }
        int num = dig.charAt(idx) - '0';
        String val = map[num];
        for(int i = 0; i < val.length(); i++){
            op.append(val.charAt(i));
            lcomb(idx+1, dig, map, ans, op);
            op.delete(op.length()-1, op.length());
        }
    }
}