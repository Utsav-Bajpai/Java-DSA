class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return nSA(nums, k) - nSA(nums, k-1);
    }
    int nSA(int[] nums, int k){
        int i = 0, j = 0, count = 0, distinct = 0;
        int[] arr = new int[nums.length+1];
        while(j < nums.length){
            if(arr[nums[j]] == 0) distinct++;
            arr[nums[j]]++;
            while(distinct > k){
                arr[nums[i]]--;
                if(arr[nums[i]] == 0) distinct--;
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}