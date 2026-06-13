class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuffer s = new StringBuffer();
        for(String i : words){
            int mod = 0, sum = 0;
            for(char j : i.toCharArray()){
                sum += weights[j - 'a'];
            }
            int c = 25 - (sum % 26);
            s.append((char) ('a' + c));
        }
        return s.toString();
    }
}