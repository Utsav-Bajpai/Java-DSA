class Solution {
    public int countCommas(int n) {
        int total = n - 999;
        if(total > 0) return total;
        else return 0;

    }
}