class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Character> existingVowels = new ArrayList<>();
        StringBuilder reverseString = new StringBuilder(s);

        for (char c: s.toCharArray()) {
            if (vowels.contains(c)) {
                existingVowels.add(c);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(reverseString.charAt(i))) {
                char replacement = existingVowels.remove(existingVowels.size() - 1);
                reverseString.setCharAt(i, replacement);
            } else reverseString.setCharAt(i, reverseString.charAt(i));
        }
        return reverseString.toString();
}