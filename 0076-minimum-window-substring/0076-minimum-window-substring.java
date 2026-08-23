class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, sidx = -1, count = 0, mlen = Integer.MAX_VALUE;
        int[] arr = new int[256];
        for(char c : t.toCharArray()){
            arr[c]++;
        }
        while(j < s.length()){
            arr[s.charAt(j)]--;
            if(arr[s.charAt(j)] >= 0){
                count++;
            }
            while(count == t.length()){
                if(mlen > j - i + 1){
                    mlen = j - i + 1;
                    sidx = i;
                }
                arr[s.charAt(i)]++;
                if(arr[s.charAt(i)] > 0) count--;
                i++;
            }
            j++;
        }
        return sidx == -1 ? "" : s.substring(sidx, sidx+mlen);
    }
}