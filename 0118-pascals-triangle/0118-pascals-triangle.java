class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int r = 1; r <= numRows; r++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int num = 1;
            for(int c = 1; c < r; c++){
                num *= (r-c);
                num /= c;
                temp.add(num);
            }
            ans.add(temp);
        }
        return ans;
    }
}