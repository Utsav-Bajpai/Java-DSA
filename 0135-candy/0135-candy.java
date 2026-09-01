class Solution {
    public int candy(int[] ratings) {
        int sum = 1, i = 1, n = ratings.length;
        while(i < ratings.length){
            if(ratings[i] == ratings[i-1]){
                sum++;
                i++;
            }
            int up = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                up++;
                sum += up;
                i++;
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                sum += down;
                down++;
                i++;
            }
            if(down > up) sum += down - up;
        }
        return sum;
    }
}