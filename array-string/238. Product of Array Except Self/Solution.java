class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];

        int leftProduct = 1, rightProduct = 1;
        for (int i = 0; i < len; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = len-1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}