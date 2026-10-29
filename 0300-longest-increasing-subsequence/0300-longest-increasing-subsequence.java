class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            int start = 0;
            int last = arr.size();
            while (start < last) {
                int mid = start + (last - start) / 2;
                if (arr.get(mid) < num) {
                    start = mid + 1;
                } else {
                    last = mid;
                }
            }
            if (start == arr.size()) {
                arr.add(num);
            } else {
                arr.set(start, num);
            }
        }
        return arr.size();
    }
}
