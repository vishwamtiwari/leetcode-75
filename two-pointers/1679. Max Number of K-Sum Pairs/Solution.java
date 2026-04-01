class Solution {
    public int maxOperations(int[] nums, int k) {
        int i = 0, j = nums.length - 1, len = nums.length - 1, count = 0;
        Arrays.sort(nums);

        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}