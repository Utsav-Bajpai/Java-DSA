class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length-1, lsum = 0, rsum = 0, msum = 0;
        while(left < k){
            lsum += cardPoints[left++];
        }
        msum = lsum;
        left--;
        while(left >= 0){
            lsum -= cardPoints[left--];
            rsum += cardPoints[right--];
            msum = Math.max(lsum + rsum, msum);
        }
        return msum;
    }
}