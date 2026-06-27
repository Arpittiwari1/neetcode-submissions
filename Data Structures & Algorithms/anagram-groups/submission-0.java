class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word:strs){
            int[] count = new int[26];
            for(char c : word.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            map.computeIfAbsent(key,k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
