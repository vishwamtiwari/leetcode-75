class StockSpanner {

    Stack<int[]> stack = new Stack<>();
    public StockSpanner() {}

    public int next(int price) {
        int result = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            result += stack.pop()[1];
        }
        stack.push(new int[] {price, result});
        return result;
    }
}