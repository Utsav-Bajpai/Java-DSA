class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int idx, int target, int[] arr,
                   List<Integer> ds, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            if (i > idx && arr[i] == arr[i - 1])
                continue;

            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            backtrack(i + 1, target - arr[i], arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}