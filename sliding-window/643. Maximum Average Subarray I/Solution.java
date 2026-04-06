class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int initialSum = 0;

        for (int i = 0; i < k; i++) {
            initialSum += nums[i];
        }
        if (nums.length == k) return (double) initialSum/k;

        int maxSum = initialSum;
        for (int j = k; j < nums.length; j++) {
            initialSum += (nums[j] - nums[j - k]);
            if (maxSum < initialSum) maxSum = initialSum;
        }
        return (double) maxSum/k;
    }
}