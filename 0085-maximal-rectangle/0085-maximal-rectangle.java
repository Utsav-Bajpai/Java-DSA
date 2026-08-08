class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int marea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') arr[j]++;
                else arr[j] = 0;
                System.out.print(arr[j]);
            }
            int area = maxhist(arr);
            marea = Math.max(area, marea);
        }
        return marea;
    }
    int maxhist(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int ma = 0;
        for(int i = 0; i < arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                int ele = stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                ma = Math.max(ma, arr[ele] * (nse - pse - 1));
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int ele = stk.pop();
            int nse = arr.length;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            ma = Math.max(ma, arr[ele] * (nse - pse - 1));
        }
        return ma;
    }
}