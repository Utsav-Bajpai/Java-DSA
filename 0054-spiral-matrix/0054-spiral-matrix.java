class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ls = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = m-1;
        int right = n-1; 
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ls.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ls.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ls.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(ls);
        return ls;
    }
}