class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < gain.length; i++) {
            altitudes[i + 1] = altitudes[i] + gain[i];
        }
        for (int j = 0; j < altitudes.length; j++) {
            maxHeight = altitudes[j] > maxHeight ? altitudes[j] : maxHeight;
        }
        return maxHeight;
    }
}