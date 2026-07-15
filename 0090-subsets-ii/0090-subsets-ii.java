class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subs(0, nums, ans, new ArrayList<>());
        return ans;
    }

    void subs(int idx, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1])continue;
            ds.add(arr[i]);
            subs(i + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}