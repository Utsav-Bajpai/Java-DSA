class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] poi = new int[2001];
        poi[0] = 0;
        int ptr1 = 0, ptr2 = 1, idx = 1;
        while(ptr1 < arr.length ){
            if(arr[ptr1] > ptr2){
                poi[idx] = ptr2;
                ptr2++;
                idx++;
            }else{ ptr1++; ptr2++;}
        }
        while(idx < poi.length){poi[idx] = ptr2; ptr2++; idx++;};
        return poi[k];
        
    }
}