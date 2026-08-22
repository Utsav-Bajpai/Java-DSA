class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int count = 0;

        for (int j = 0; j < nums.length; j++) {

            // Add nums[j]
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Too many distinct numbers
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            // Every subarray ending at j is valid
            count += j - i + 1;
        }

        return count;
    }
}