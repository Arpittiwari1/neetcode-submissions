class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       char[] count = new char[26];
      for(int i=0;i<s.length();i++){
        count[s.charAt(i)-'a']++;
      }
      for(int i =0;i<t.length();i++){
        count[t.charAt(i)-'a']--;
      }
      for(int i=0;i<25;i++){
        if(count[i] != 0) return false;
      }
      return true;
    }
}
