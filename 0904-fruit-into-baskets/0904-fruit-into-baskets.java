class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ml = 0;
        while(j < fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() > 2){
                if(map.get(fruits[i]) == 1) map.remove(fruits[i]);
                else map.put(fruits[i], map.get(fruits[i])-1);
                i++;
            }
            ml = Math.max(ml, j - i + 1);
            j++;
        }
        return ml;
    }
}