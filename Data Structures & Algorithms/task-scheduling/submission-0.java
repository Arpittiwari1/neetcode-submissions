class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        int maxFreq = 0;
        int countMax = 0;
        for(int f:freq){
            if(f>maxFreq){
                maxFreq = f;
                countMax = 1;
            }else if(f==maxFreq){
                countMax++;
            }
        }
        int partCount = maxFreq-1;
        int partLength = n+1;
        int minTime = partCount*partLength+countMax;

        return Math.max(tasks.length,minTime);
    }
}
