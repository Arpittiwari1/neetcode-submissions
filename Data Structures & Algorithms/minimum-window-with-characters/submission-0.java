class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for(char c:t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int left = 0; int right = 0;  int required = freq.size(); int formed = 0;
        Map<Character,Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(freq.containsKey(c) && window.get(c).intValue() == freq.get(c).intValue()){
                formed++;
            }
            while(left<=right && formed == required){
                if(right-left+1<minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(freq.containsKey(leftChar) && window.get(leftChar)<freq.get(leftChar)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(start,start+minLen);
    }
}
