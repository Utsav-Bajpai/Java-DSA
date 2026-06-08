class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1;
        int min = Integer.MAX_VALUE, max = 0;
        for(int i : bloomDay){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int minDay = -1;
        while(min <= max){
            int mid = (min+max)/2;
            boolean Day = possible(bloomDay, mid, m, k);
            if(Day == false) min = mid+1;
            else{
                minDay = mid;
                max = mid-1;
            }
        }
        return minDay;
    }
    boolean possible(int[] arr, int day, int m, int k){
        int cnt = 0, nOB = 0;
        for(int i : arr){
            if( i <= day) cnt++;
            else{ nOB += cnt/k; cnt = 0;}
            if(nOB == m) return true;
        }
        nOB += cnt/k;
        if(nOB >= m) return true;
        else return false;
    }
}