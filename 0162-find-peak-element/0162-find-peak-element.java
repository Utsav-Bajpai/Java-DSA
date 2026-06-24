class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int low = 0;
        int high = nums.length - 1;

        if (nums[low] > nums[low + 1]) return low;
        if (nums[high] > nums[high - 1]) return high;

        low++;
        high--;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } 
            else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}