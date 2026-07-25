class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        int[] pri = new int[n+1];
        for(int i = 2; i < n; i++){
            pri[i] = 1;
        }
        for(int i = 2; i * i <  n; i++){
            if(pri[i] == 1){
                for(int j = i * i; j <=  n; j += i){
                    pri[j] = 0;
                }
            }
        }
        for(int i : pri){
            if(i == 1) cnt++;
        }
        return cnt;
    }
}