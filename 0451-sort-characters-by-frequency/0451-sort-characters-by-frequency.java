class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(hm.keySet());

        list.sort((a, b) -> hm.get(b) - hm.get(a));

        StringBuilder ans = new StringBuilder();

        for (char ch : list) {
            int freq = hm.get(ch);

            for (int i = 0; i < freq; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}