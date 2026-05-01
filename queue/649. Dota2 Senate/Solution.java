class Solution {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        LinkedList<Integer> rQueue = new LinkedList<>();
        LinkedList<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (chars[i] == 'R') rQueue.add(i);
            else dQueue.add(i);
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.peek();
            int dIndex = dQueue.peek();

            if (rIndex < dIndex) {
                dQueue.poll();
                rQueue.poll();
                rQueue.add(rIndex + senate.length());
            } else {
                rQueue.poll();
                dQueue.poll();
                dQueue.add(dIndex + senate.length());
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}