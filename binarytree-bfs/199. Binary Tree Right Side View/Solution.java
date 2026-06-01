class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);

                if (i == levelSize - 1) {
                    results.add(currNode.val);
                }
            }
        }
        return results;
    }
}