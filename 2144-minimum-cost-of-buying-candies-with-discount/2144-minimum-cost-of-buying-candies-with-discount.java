class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int i = cost.length-3;
        int j = cost.length-1;
        while(j >= 0){
            total += cost[j];
            if(j!=0) total += cost[j-1];
            j = i-1;
            i = j-2;
        }
        return total;
    }
}