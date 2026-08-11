class StockSpanner {
    Stack<int[]> stk = new Stack<>();
    int idx;
    public StockSpanner() {
        idx = 0;

    }
    
    public int next(int price) {
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            stk.pop();
        }
        int ans;
        if(stk.isEmpty()) ans = idx + 1;
        else ans = idx - stk.peek()[1];
        stk.push(new int[]{price, idx});
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */