class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        
        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If only spaces
        if (i == n) return 0;

        // 2. Handle sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // 3. Convert digits
        long result = 0;  // Use long to detect overflow
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            // 4. Handle overflow
            if (sign * result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }

        return (int)(sign * result);
    }
}

