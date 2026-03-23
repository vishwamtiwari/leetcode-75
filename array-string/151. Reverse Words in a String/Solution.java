class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        StringBuilder reverseString = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            if(!words[i].isEmpty()) result.append(words[i]).append(" ");
        }
        return reverseString.toString().trim();
    }
}