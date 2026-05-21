class Solution {
    // public int maxDepth(String s) {
    //     int max = 0;
    //     int m = 0;
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i)=='(') m++;
    //         else if(s.charAt(i)==')') {max=Math.max(m,max); m--;}
    //     }
    //     return max;
    // }

    public int maxDepth(String s) {
        int max = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                depth++;
                max = Math.max(max, depth);
            } 
            else if (ch == ')') {
                depth--;
            }
        }

        return max;
    }

}