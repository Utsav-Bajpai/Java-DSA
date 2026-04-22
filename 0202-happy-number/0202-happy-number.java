class Solution {
    public boolean isHappy(int n) {
        Set<Integer> usedNum = new HashSet<>();
        usedNum.add(n);
        int num = n;
        while(true){
            int sum = 0;
            while(num > 0){
                int rem  = num % 10;
                sum += rem*rem;
                num = num/10;
            }
            if(sum == 1) return true;
            else if(usedNum.contains(sum)) return false;
            usedNum.add(sum);
            num = sum;
        }
    }
}