class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Prefix sum array
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int totalSum = prefix[n];

        // Calculate result for each index
        for (int i = 0; i < n; i++) {
            int leftSum = nums[i] * i - prefix[i];
            int rightSum = (totalSum - prefix[i] - nums[i]) 
                            - nums[i] * (n - i - 1);
            result[i] = leftSum + rightSum;
        }

        return result;
    }
}