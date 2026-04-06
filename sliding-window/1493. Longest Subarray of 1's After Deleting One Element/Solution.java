class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, maxOne = 0, countZero  = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                countZero++;
            }

            if (countZero > 1) {
                if (nums[i] == 0) countZero--;
                i++;
            }
            maxOne = Math.max(maxOne, (j - i));
            j++;
        }
        return maxOne;
    }
}