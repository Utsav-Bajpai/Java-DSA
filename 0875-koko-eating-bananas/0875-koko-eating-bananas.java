class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int n = piles.length, low = 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            double k = bph(piles, mid);
            if(k <= h) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
    double bph(int[] arr, int hr){
        double ht = 0;
        for(int i : arr){
            ht += (i + hr - 1) / hr;
        }
        return ht;
    }
}