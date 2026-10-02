class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n;i++){
            int rob = nums[i] + arr[i - 2];
            int skip = arr[i - 1];

            arr[i] = Math.max(rob, skip);
        }

        return arr[n - 1];
    }
}