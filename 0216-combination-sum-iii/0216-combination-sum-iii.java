class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        comb3(1, k, n, ans, new ArrayList<>());
        return ans;
    }

    void comb3(int idx, int k, int tar, List<List<Integer>> ans, List<Integer> ds) {

        if(ds.size() == k){
            if(tar == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i = idx; i <= 9; i++){
            if(i > tar) break;

            ds.add(i);
            comb3(i + 1, k, tar - i, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}