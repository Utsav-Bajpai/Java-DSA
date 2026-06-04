class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, 0, nums.length-1, target);
        int last = lastOcc(nums, 0, nums.length-1, target);
        return new int[]{first, last};
    }
    int firstOcc(int[] arr, int low, int high, int target){
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                first = mid;
                high = mid-1;
            }else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return first;
    }
    int lastOcc(int[] arr, int low, int high, int target){
        int last = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                last = mid;
                low = mid+1;
            }else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return last;
    }
}