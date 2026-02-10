class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            runningSum[i] = total;
        }
        return runningSum;
    }
}
