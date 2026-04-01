class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int write = 0;

        for (int read = 0; read < len; read++) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
        }

        for (int j = write; j < len; j++) {
            nums[j] = 0;
        }
    }
}