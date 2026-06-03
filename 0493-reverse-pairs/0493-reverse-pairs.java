class Solution {
    public int reversePairs(int[] nums) {
        int cnt = 0;
        cnt = mergeSort(nums, 0, nums.length-1);
        return cnt;
    }
    int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high) return 0;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += count(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    void merge(int[] arr, int low, int mid, int high){
        List<Integer> ls = new ArrayList<>();
        int a = low, b = mid+1;
        while(a <= mid && b <= high){
            if(arr[a] <= arr[b]){
                ls.add(arr[a]);
                a++;
            }else{
                ls.add(arr[b]);
                b++;
            }
        }
        while(a <= mid){
            ls.add(arr[a]);
            a++;
        }
        while(b <= high){ ls.add(arr[b]); b++;}
        for(int i = low; i <= high; i++){
            arr[i] = ls.get(i-low);
        }
    }
    int count(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int cnt = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long)arr[i] > 2L * arr[right]){
                right++;
            }
            cnt += right-(mid+1);
        }
        return cnt;
    }
}