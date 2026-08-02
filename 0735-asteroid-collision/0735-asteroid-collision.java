class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            int as = asteroids[i];
            if(as > 0){
                stk.push(as);
                continue;
            }
            while(!stk.isEmpty() && stk.peek() > 0 && as < 0){
                if(stk.peek() > Math.abs(as)) as = 0;
                else if (stk.peek() < Math.abs(as)) stk.pop();
                else{
                    as = 0;
                    stk.pop();
                }
            }
            if(as < 0) stk.push(as);
        }
        int[] arr = new int[stk.size()];
        for(int i = arr.length-1; i >= 0 ; i--){
            arr[i] = stk.pop();
        }
        return arr;
    }
}