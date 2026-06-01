class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int num = 1;
            for(int r = 1; r < i; r++){
                num *= (i-r);
                num /= r;
                temp.add(num);
            }
            ans.add(temp);
        }
        return ans;
    }
}