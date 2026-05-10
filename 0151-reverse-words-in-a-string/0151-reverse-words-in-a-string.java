class Solution {
    public String reverseWords(String s) {
       String[] arr = s.trim().split("\\s++");
       int a = 0, b = arr.length-1;
       while(a <= b){
        String temp = arr[a].trim();
        arr[a] = arr[b].trim();
        arr[b] = temp;
        a++;
        b--;
       }
       return String.join(" ", arr);
       
    }
}