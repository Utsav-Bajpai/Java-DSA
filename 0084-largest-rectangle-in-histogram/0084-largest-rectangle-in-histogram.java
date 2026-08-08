class Solution {
    public int largestRectangleArea(int[] heights) {
        int marea = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                int ele = stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                marea = Math.max(marea, heights[ele]*(nse - pse - 1));
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int ele = stk.pop();
            int nse = heights.length;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            marea = Math.max(marea, heights[ele]*(nse - pse - 1));
        }
        return marea;
    }
}