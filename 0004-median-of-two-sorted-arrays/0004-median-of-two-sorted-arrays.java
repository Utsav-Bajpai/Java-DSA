class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int i = 0;
        int j = 0;
        int ptr = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                arr[ptr] = nums2[j];
                j++;
                ptr++;
            }else{
                arr[ptr] = nums1[i];
                i++;
                ptr++;
            }
        }
        while(i < nums1.length){arr[ptr] = nums1[i];ptr++;i++;}
        while(j < nums2.length){arr[ptr] = nums2[j]; ptr++;j++;}
        if(n%2 == 0) return (arr[n/2] + arr[(n/2) - 1])/2.0;
        else return arr[n/2];
    }
}