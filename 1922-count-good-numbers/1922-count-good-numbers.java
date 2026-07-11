class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        if(n == 1) return 5; 
        long odd = power(4, n/2);
        long even = power(5, (n+1)/2);
        return (int)((odd * even) % MOD);
    }
    long power(int x, long n){
        if(n == 0) return 1;
        long half  = power(x, n/2);
        long res = (half * half) % MOD;
        if(n % 2 == 1) return (res * x) % MOD;
        return res;
    }
}