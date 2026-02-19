class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try all possible substring lengths up to n/2
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) continue; // must divide evenly

            String sub = s.substring(0, len);
            int repeats = n / len;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < repeats; i++) {
                sb.append(sub);
            }

            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}

