class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;
        int low = 0;
        double sum = 0;
        for(int i : nums){
            low = Math.max(low, i);
            sum += i;
        }
        while(low <= sum){
            int mid = (int)(low+sum)/2;
            int noa = noOfArr(nums, mid);
            if(noa <= k){
                sum = mid-1;
            }else low = mid+1;
        }
        return low;
        
    }
    int noOfArr(int[] arr, int max){
        int subArr = 1, soa = 0;
        for(int i : arr){
            if(soa + i <= max) soa += i;
            else{
                subArr++;
                soa = i;
            }
        }
        return subArr;
    }
            
}