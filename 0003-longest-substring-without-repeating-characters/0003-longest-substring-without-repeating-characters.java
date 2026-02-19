class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        
        // Array to store last index of each character
        int[] lastIndex = new int[128]; // ASCII size
        
        // Initialize with -1 (character not seen)
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character was seen and is inside current window
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }
            
            // Update last seen index
            lastIndex[currentChar] = right;
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
