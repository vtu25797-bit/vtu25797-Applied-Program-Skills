class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currentMax = 0, maxSum = nums[0];
        int currentMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            // Standard Kadane for max subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            
            // Kadane for min subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
            
            totalSum += num;
        }
        
        // If all numbers are negative, return maxSum
        if (maxSum < 0) {
            return maxSum;
        }
        
        // Return max of normal max and circular max
        return Math.max(maxSum, totalSum - minSum);
    }
}
