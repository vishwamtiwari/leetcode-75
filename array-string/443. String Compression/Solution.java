class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int read = 0;
        int write = 0;

        while (read < len) {
            char currentChar = chars[read];
            int count = 0;

            while (read < len && currentChar == chars[read]) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                for (char c: Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}