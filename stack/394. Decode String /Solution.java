class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch != ']') stack.push(String.valueOf(ch));
            else {
                StringBuilder subStr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    subStr.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }

                int count = Integer.parseInt(k.toString());
                stack.push(subStr.toString().repeat(count));
            }
        }

        String res = String.join("", stack);
        return res;
    }
}