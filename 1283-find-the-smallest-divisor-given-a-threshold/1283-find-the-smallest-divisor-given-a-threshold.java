class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = 0, div = Integer.MAX_VALUE;
        for(int i : nums){
            max = Math.max(i, max);
        }
        int low = min, high = max;
        while(low <= high){
            int mid = (low + high) / 2;
            double divSum = calc(nums, mid);
            if(divSum <= threshold){
                div = Math.min(div, mid);
                high = mid-1;
            }else low = mid+1;
        }
        return div;
    }
    double calc(int[] arr, int div){
        double sum = 0;
        for(int i : arr){
            sum += Math.ceil((float)i/div);
        }
        return sum;
    }
}