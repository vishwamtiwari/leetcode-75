class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentHeight = (height[left] < height[right]) ? height[left] : height[right];
            int currentArea = currentHeight * (right - left);

            if (currentArea > maxArea) maxArea = currentArea;

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}