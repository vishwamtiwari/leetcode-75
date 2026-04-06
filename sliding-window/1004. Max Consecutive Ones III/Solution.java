class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, countZero = 0, maxLen = 0;

        while (j < nums.length) {

            if (nums[j] == 0) {
                countZero++;
            }

            if (countZero > k) {
                if (nums[i] == 0) countZero--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;

        }
        return maxLen;
    }
}