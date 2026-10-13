class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Find the first character with a frequency of 1
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // If no unique character exists
        return -1;
    }
}