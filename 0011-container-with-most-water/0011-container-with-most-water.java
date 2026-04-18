class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left= 0;
        int right = height.length-1;
        while(left<right){
            int len = right-left;
            int wid = height[left] >= height[right] ? height[right] : height[left];
            if(len * wid > area) area = len * wid;
            if(height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
}