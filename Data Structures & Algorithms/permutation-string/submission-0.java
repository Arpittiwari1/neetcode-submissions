class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int[] s1Count= new int[26];
      int[] s2Count = new int[26];
      for(char c:s1.toCharArray()){
        s1Count[c-'a']++;
      }
      for(int i=0;i<s2.length();i++){
        s2Count[s2.charAt(i)-'a']++;
        if(i>=s1.length()){
            s2Count[s2.charAt(i-s1.length())-'a']--;
        }
        if(matches(s1Count,s2Count)){
            return true;
        }
      }
      return false;
    }

private boolean matches(int[] s1Count , int[] s2Count){
    for(int i=0;i<26;i++){
        if(s1Count[i] != s2Count[i]){
            return false;
        }
    }
    return true;
}
}
