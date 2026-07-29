class MinStack {
    Stack<Long> stk;
    long min;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        long value = val;
        if(stk.isEmpty()){
            stk.push(value);
            min = value;
        }
        else{
            if(value > min) stk.push(value);
            else{
                stk.push((2 * value) - min);
                min = value;
            }
        }
    }
    
    public void pop() {
        if(stk.isEmpty()){
            return;
        }
        long n = stk.peek();
        if(n < min) min = 2 * min - n;
        stk.pop();
    }
    
    public int top() {
        if(stk.isEmpty()){
            return -1;
        }
        long n = stk.peek();
        if(n < min) return (int) min;
        return (int) n;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */