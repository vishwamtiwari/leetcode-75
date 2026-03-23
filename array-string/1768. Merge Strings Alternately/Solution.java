class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int i = 0, j = 0;

        StringBuilder result = new StringBuilder();

        while(i < len1 && j < len2) {
            result.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }
        if (len1 > i) result.append(word1.substring(i, len1));
        if (len2 > j) result.append(word2.substring(j, len2));
        return result.toString().trim();
    }
}